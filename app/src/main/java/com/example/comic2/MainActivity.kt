package com.example.comic2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.comic2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_inform.view.*

class MainActivity : AppCompatActivity(), OnComicItemClickListner {
    private lateinit var comicRecyclerview: RecyclerView
    private lateinit var comicArrayList: ArrayList<comic>
    lateinit var imageId : Array<Int>
    lateinit var name : Array<String>
    lateinit var descrip : Array<String>
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("hello","hi")
        imageId= arrayOf(
            R.drawable.ic_myroommate,
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i
        )

        name= arrayOf(
            "MY ROOMMATE ISN'T FROM THIS WORLD",
            "BỆNH VIỆN MA ÁM",
            "DU THUYỀN ĐẪM MÁU",
            "TRÒ CHƠI SONG TRÙNG",
            "PHẦN NHÂN TÍNH CUỐI CÙNG",
            "KHU TRỌ QUỶ ÁM",
            "VÙNG ĐẤT XÁM",
            "BÍ NGÔ CUỒNG SÁT - PUMPKIN NIGHT",
            "ITO JUNJI CAT'S DIARY",
            "FRANKENSTEIN",
        )
        descrip= arrayOf(
            """Bỗng dưng tôi có thêm bạn 
                cùng phòng"""".trimMargin(),
            """Một bệnh viện từng có rất nhiều bệnh nhân
               tới khám cùng đội ngũ bác sĩ lành nghề,
               nhưng sau vì một lý do bí ẩn mà nó phải đóng cửa. 
               Cho tới khi có 1 bác sĩ trẻ đầy tham vọng đã quyết định cho mở cửa lại nơi này. 
               Tuy nhiên những hiện tượng kỳ lạ bắt đầu xuất hiện...""",
            "Một du thuyền sang chảnh được phát vé miễn phí cho các khách mời may mắn, đổi lại họ phải đeo trên tay nhãn dán mang kí hiệu nhóm máu của mình. Từng hành khách trên con thuyền đâu biết rằng họ chính là những con mồi béo bở cho lũ nhà giàu đứng sau?!",
            "Nữ sinh Song Soo Ji tình cờ nhặt được một quả trứng bí ẩn trong giờ nghỉ trưa, nhưng cô không ngờ rằng bản thân mình đã bị cuốn vào 1 trò chơi bởi kẻ song trùng của chính bản thân mình! Một trò chơi chết chóc, vòng lặp không lối thoát của ma quỷ. Tiếng chuông reo báo kết thúc tiết học vào 5h chiều cũng là tiếng chuông báo hiệu cho một ai đó sẽ phải chết!!",
            "Thế giới lâm vào đại dịch zombie bí ẩn, nhân loại đã lâm vào bờ vực tuyệt chủng. Giờ đây quân đội cũng chỉ tự lo lấy bản thân mình, con người tìm mọi cách để tồn tại kể cả giết hại lẫn nhau. Và trong tình cảnh đó, anh ta đã xuất hiện - một kẻ mang trong mình mầm bệnh zombie. Anh ta vẫn luôn tự đấu tranh với bản thân để giữ lại nhân tính của mình, để có thể sống sót, và để có thể bảo vệ được những người quan trọng đối với anh ta....",
            "Mấy ngày gần đây, ở căn hộ bên dưới cứ có một mùi thối rữa kỳ lạ bốc lên. Vài hôm sau, thằng bạn thân của tôi tự dưng mất tích. Cả cô gái sống trong căn hộ đó cũng vậy. Tiếp theo sẽ đến lượt ai đây…?",
            "Sáu người bạn học là những vị khách đầu tiên được mời đến GremoryLand, một công viên giải trí đáng sợ hứa hẹn sẽ mang lại trải nghiệm độc đáo không kém phần ma quái. Nhưng một khi đã bắt đầu sẽ không thể quay đầu lại được, và họ phát hiện họ bị thử thách ngoài sức tưởng tượng, đối mặt với nỗi sợ hãi tận cùng để sống sót.",
            "Một kẻ giết người đeo mặt nạ bí ngô? Nguyên nhân của tội ác này là ...?",
            "Đây là series về mèo của Tác giả truyện kinh dị Junji Ito",
            "Tuyển tập Volume 16 truyện kinh dị của tác giả Junji Ito"
        )

        comicRecyclerview = findViewById(R.id.recycleview)
        comicRecyclerview.layoutManager = LinearLayoutManager(this)
        comicArrayList = arrayListOf<comic>()
        getUserData()
        val search = binding.searchBar

//        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                comicRecyclerview.adapter.get
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                TODO("Not yet implemented")
//            }
//
//        })
    }

    override fun onItemClick(item: comic, position: Int) {
        val intent = Intent(this,InformActivity::class.java )
        intent.putExtra("key_name", item.name)
        intent.putExtra("key_img", item.imgImage.toString())
        intent.putExtra("key_dis", item.descrip)
        startActivity(intent)
    }
    fun getUserData(){
        for(i in imageId.indices){
            val comics= comic(imageId[i], name[i], descrip[i])
            comicArrayList.add(comics)
        }
        comicRecyclerview.adapter= MyAdapter(comicArrayList, this)
    }

}