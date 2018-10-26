# CustomVIewLibrary
自定义对话框，支持样式修改，随心所欲的定制
### How to use it?
Step 1. Add it in your root build.gradle at the end of repositories:

    allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
     }
     
Step 2. Add the dependency 
   	 
   	 dependencies {
      	        implementation 'com.github.langsun:CustomVIewLibrary:v1.0'
      	}

### 对话框 
 <img src="https://github.com/langsun/CustomVIewLibrary/blob/master/img/center_dialog.png" width=480 height=800 />
 
 
 1. 直接在所需要的地方进行显示，看得到的样式都可以自定义修改
     
 
        public void shoeDialog() {
        
        CustomCenterDialog.Builder builder = new CustomCenterDialog.Builder();
        
        builder.setContext(MainActivity.this)
                .setTitle("测试一下")
                .setTitleTextColor(R.color.colorAccent)
                .setTitleTextSize(30)
                .setMessage("这只是一个测试")
                .setLeftBtnText("NO", null)
                .setRightBtnText("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "YES", Toast.LENGTH_LONG).show();
                    }
                }).setRightBtnTextBg(R.drawable.red_shape)
                .setRightBtnTextColor(R.color.color_ffffff)
                .setDialogBg(R.drawable.my_dialog_shape)
                .create()
                .show();

        }
 2.  如果你感觉上面的比较麻烦，每次都要new new new，每次都要设置样式，那么你可以自己封装一个DialogUtil，应为每个应用弹窗的样式是一致的，所以用一个dialogUtil把弹窗的样式封装了，在需要弹窗的地方直接调用DialogUtil来显示
 
          public class DialogUtil {

          public static void showDialog(final Context context, String title, String               message, String leftButText, DialogInterface.OnClickListener leftButOnClickListener, String rightButText, DialogInterface.OnClickListener rightButOnClickListener) {
          
          CustomCenterDialog.Builder builder = new CustomCenterDialog.Builder();
        
          builder.setContext(context)
                .setTitle(title)
                .setTitleTextColor(R.color.colorAccent)
                .setTitleTextSize(30)
                .setMessage(message)
                .setRightBtnTextBg(R.drawable.red_shape)
                .setRightBtnTextColor(R.color.color_ffffff)
                .setDialogBg(R.drawable.my_dialog_shape)
                .setLeftBtnText(leftButText, leftButOnClickListener)
                .setRightBtnText(rightButText, rightButOnClickListener)
                .create()
                .show();
            }
         }
        
   3. 对话框参数
   
          setContext(Context mContext)                                   :设置上下文 
          getContext()                                                   :获取上下文 
      
          setTitle(String mTitle)                                        :设置标题  
          getTitle()                                                     :获取标题 
          setTitleTextSize(int mTitleTextSize)                           :设置标题字体大小
          setTitleTextColor(int mTitleTextColor)                         :设置标题字体颜色
    
          setMessage(String mMessage)                                    :设置具体信息  
          getMessage()                                                   :获取具体信息 
          setMessageTextSize(int mMessageTextSize)                       :设置具体信息字体大小 
          setMessageTextColor(int mMessageTextColor)                     :设置具体信息字体颜色 
    
          setLeftBtnText(String mLeftBtnText, DialogInterface.OnClickListener listener)                                                          :设置左边按钮文本以及点击事件   
          getLeftBtnText()                                               :获取左边按钮文本 
          setLeftBtnTextSize(int mLeftBtnTextSize)                       :设置左边按钮文本字体大小
          setLeftBtnTextColor(int mLeftBtnTextColor)                     :设置左边按钮文本字体颜色
    
          setRightBtnText(String mRightBtnText, DialogInterface.OnClickListener listener)                                                           :设置右边按钮文本以及点击事件 
          getRightBtnText()                                               :获取右边按钮文本 
          setRightBtnTextSize(int mRightBtnTextSize)                      :设置右边按钮文本字体大小    
          setRightBtnTextColor(int mRightBtnTextColor)                    :设置右边按钮文本字体颜色
    
          setDialogBg(int mDialogBg)                                      :设置Dialog整体的背景样式
          setLeftBtnTextBg(int mLeftBtnTextBg)                            :设置左边按钮背景样式
          setRightBtnTextBg(int mRightBtnTextBg)                          :设置右边按钮背景样式
    
          setIsCanceledOnTouchOutside(boolean isCanceledOnTouchOutside)   :设置点击外部是否可以关闭弹窗      
 
### 底部弹窗  
  <img src="https://github.com/langsun/CustomVIewLibrary/blob/master/img/bottom_dialog.png" width=480 height=800 />

  
 1. 底部弹窗的更方便，直接传入你所需弹窗的view的xml，然后传入所需点击view的id，就是这么这么简单
 
        public void shoeBottomView() {
              CustomBottomDialog dialog = new CustomBottomDialog(this,
              R.layout.dialog_bottom_layout, new int[]{R.id.tv_sure, R.id.tv_cancel});
        
              dialog.setClickListener(new CustomBottomDialog.ClickListener() {
                    @Override
                    public void onItemClick(CustomBottomDialog dialog, View view) {
                          switch (view.getId()) {
                               case R.id.tv_sure:
                               Toast.makeText(MainActivity.this, "sure", Toast.LENGTH_LONG).show();
                                break;
                    }

               }
          });
             dialog.show();
        } 


2. 构造方法介绍

        CustomBottomDialog(Context context, int layoutRes, int[] itemIds) 
        CustomBottomDialog(Context context, int layoutRes, int[] itemIds, int width) 
        CustomBottomDialog(Context context, int layoutRes, int[] itemIds, int width, boolean isCanceledOnTouchOutside)
    
        Context context                                                 :上下文
        int layoutRes                                                   :要显示的xml布局文件
        int[] itemIds                                                   :所需点击事件view的id
        int width                                                       :dialog的宽度(1:宽度整屏，9/10:宽度为整屏的90%)
        boolean isCanceledOnTouchOutside                                :点击外部是否关闭
    
    
### ItemView 
<img src="https://github.com/langsun/CustomVIewLibrary/blob/master/img/item_view.png" width=480 height=800 />


1. 这是主要针对个人中心itemview的封装，

        <com.sun.customviewlibrary.CustomItemView
             android:id="@+id/civ_binding_phone"
             android:layout_width="match_parent"
             android:layout_height="45dp"
             android:layout_marginTop="10dp"
             android:background="@color/color_ffffff"
             sun:left_image="@drawable/person_data_phone"
             sun:left_text="手机号绑定"
             sun:right_image="@drawable/next"
             sun:right_text="未绑定"
             sun:right_text_color="@color/color_D80000"
             sun:view_line_visible="false"></com.sun.customviewlibrary.CustomItemView> 
        
 2. 方法介绍
     
         setClickListener(ClickListener clickListener)                   :点击事件       
        
        
3. 这个能实现样式的自定义，但是对间距没有自定义修改方法，我把这个自定义view的代码放在了demo中，如果这个itemview无法满足项目需求事，可以自己复制CustomItemView，只需换一个xml布局即可    
