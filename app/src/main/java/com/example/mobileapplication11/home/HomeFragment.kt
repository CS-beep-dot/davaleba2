class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostsAdapter
    private val postList = mutableListOf<Post>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        postAdapter = PostsAdapter(postList)
        recyclerView.adapter = postAdapter

        fetchPostsFromFirebase()

        return view
    }

    private fun fetchPostsFromFirebase() {
        val database = FirebaseDatabase.getInstance().getReference("posts")

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                postList.clear()
                for (postSnapshot in snapshot.children) {
                    val post = postSnapshot.getValue(Post::class.java)
                    if (post != null) {
                        postList.add(post)
                    }
                }
                postAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "ver daiposta: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
