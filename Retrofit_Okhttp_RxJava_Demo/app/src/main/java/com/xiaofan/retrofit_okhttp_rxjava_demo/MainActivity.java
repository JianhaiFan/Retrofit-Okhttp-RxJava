
package com.xiaofan.retrofit_okhttp_rxjava_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.Course;
import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.Student;
import com.xiaofan.retrofit_okhttp_rxjava_demo.constant.Constant;
import com.xiaofan.retrofit_okhttp_rxjava_demo.util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
/**
 * @author: 范建海
 * @createTime: 2017/3/15 11:44
 * @className:  MainActivity
 * @description: RxJava单独测试演练
 * http://blog.csdn.net/mlq8087/article/details/51891005
 * @changed by:
 */
public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private OkHttpClient mOkHttpClient;

    private ImageView iv_icon;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //http://192.168.1.24:9090/sysCommon/control/restful/ajaxGetVerificationCode
//        0 = {HashMap$HashMapEntry@830049680328} "partyClient" -> "appTypeEnum_0"
//        1 = {HashMap$HashMapEntry@830049680216} "type" -> "5006"
//        2 = {HashMap$HashMapEntry@830049680184} "userLoginId" -> "83112345678"
//        {"status":"2","msg":"该手机号已被注册"}

        // 初始OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间
                .readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(10, TimeUnit.SECONDS);//设置写入超时时间
        mOkHttpClient = builder.build();
        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(mOkHttpClient)
                .build();

        iv_icon = (ImageView) findViewById(R.id.iv_icon);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public void onClick(View view) {

//        IApi iApi = retrofit.create(IApi.class);

//        Call<User> call = iApi.ajaxGetVerificationCode("appTypeEnum_0","5006","83133333333");


//        ParamBean paramBean = new ParamBean("appTypeEnum_0","5006","83133333333");
//        Call<User> call = iApi.ajaxGetVerificationCode(paramBean);

//        Map<String,String> params = new HashMap<String,String>();
//        params.put("partyClient","appTypeEnum_0");
//        params.put("type","5006");
//        params.put("userLoginId","83112345678");


//        Observable<User> observable = iApi.ajaxGetVerificationCode(paramBean);
//
//        observable.subscribeOn(Schedulers.io())
//                  .unsubscribeOn(Schedulers.io())
//                  .observeOn(AndroidSchedulers.mainThread())
//                  .subscribe(new Subscriber<User>() {
//                            @Override
//                            public void onCompleted() {
//                                LogUtil.e("onCompleted..");
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                LogUtil.e("Throwable..: " + e.getMessage());
//                            }
//
//                            @Override
//                            public void onNext(User user) {
//                                LogUtil.e("onNext: " + user.getStatus());
//                                LogUtil.e("onNext: " + user.getMsg());
//                            }
//
//                            @Override
//                            public void onStart() {
//                                super.onStart();
//                                LogUtil.e("onStart..");
//                            }
//                        }
//
//                );
// ===========================================================================================================
// ===========================================================================================================
//        // 创建观察者
//        Subscriber<User> subscriber = new Subscriber<User>() {
//            @Override
//            public void onCompleted() {
//                LogUtil.e("onCompleted...");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtil.e("onError...");
//            }
//
//            @Override
//            public void onNext(User user) {
//                LogUtil.e("onNext...");
//                LogUtil.e("status: " + user.getStatus() + ",msg: " + user.getMsg());
//            }
//
//            @Override
//            public void onStart() {
//                super.onStart();
//                LogUtil.e("onStart...");
//            }
//        };
//
//        // 创建被观察者
//        Observable<User> observable = Observable.create(new Observable.OnSubscribe<User>() {
//            @Override
//            public void call(Subscriber<? super User> subscriber) {
//                User user = new User("1","用户1");
//                subscriber.onNext(user);
//
//                user.setStatus("2");
//                user.setMsg("用户2");
//                subscriber.onNext(user);
//
//                user.setStatus("3");
//                user.setMsg("用户3");
//                subscriber.onNext(user);
//
//                subscriber.onCompleted();
//            }
//        });
//
//
//        // 关联观察者和被观察者
//        observable.subscribe(subscriber);
// ===========================================================================================================
// ===========================================================================================================
//        // 模拟观察者的不完整回调测试
//        // 模拟观察者回调方法onNext
//        Action1<User> onNextAction = new Action1<User>() {
//            // onNext()
//            @Override
//            public void call(User user) {
//               LogUtil.e("onNextAction call: ");
//                LogUtil.e("status: " + user.getStatus() + ", msg: " + user.getMsg());
//            }};
//        //
//        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
//            // onError()
//            @Override
//            public void call(Throwable throwable) {
//                // Error handling
//                LogUtil.e("onErrorAction call: ");
//            }};
//
//        Action0 onCompletedAction = new Action0() {
//            // onCompleted()
//            @Override
//            public void call() {
//                LogUtil.e("onCompletedAction call: ");
//            }};
        // 比较复杂形式的被观察者
//        Observable<User> observable = Observable.create(new Observable.OnSubscribe<User>() {
//            @Override
//            public void call(Subscriber<? super User> subscriber) {
//                User user = new User("1","用户1");
//                subscriber.onNext(user);
//
//                user.setStatus("2");
//                user.setMsg("用户2");
//                subscriber.onNext(user);
//
//                user.setStatus("3");
//                user.setMsg("用户3");
//                subscriber.onNext(user);
//
//                subscriber.onCompleted();
//            }
//        });


//        User user1 = new User("1","用户1");
//        User user2 = new User("2","用户2");
//        User user3 = new User("3","用户3");
//
//
//        User [] users = new User[]{user1,user2,user3};

        // 简化被观察者形式1
//        Observable<User> observable = Observable.just(user1,user2,user3);
        // 简化被观察者形式2
//        Observable<User> observable = Observable.from(users);

        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
//        observable.subscribe(onNextAction);// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
//        observable.subscribe(onNextAction, onErrorAction);// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
//        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

//==========================================================================================
//==========================================================================================

        // 造一个观察者模式,用于加载图片
        // 创建被观察者
//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                // 被观察者的回调
//                Drawable drawable = getResources().getDrawable(R.drawable.ic_icon);
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//
//            }
//
//        })
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Subscriber<Drawable>() {
//            // 观察者的回调
//            @Override
//            public void onCompleted() {
//                LogUtil.e("onCompleted...");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtil.e("onError...");
//            }
//
//            @Override
//            public void onNext(Drawable drawable) {
//                LogUtil.e("onNext...");
//                iv_icon.setImageDrawable(drawable);
//            }
//        });
//==========================================================================
//==========================================================================
//        线程控制1
//        Observable.just(1,2,3,4,5)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Integer>() {
//                    @Override
//                    public void call(Integer number) {
//                        LogUtil.e("number: " + number);
//                    }
//                });

        // 线程控制2
//        Observable.create(new Observable.OnSubscribe<Integer>() {
//
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                // 在这里调用观察者的回调方法
//                LogUtil.e("被观察者的方法被调用call");
////                subscriber.onNext(111);
//                subscriber.onNext(222);
////                subscriber.onError(new Throwable());
//                subscriber.onCompleted();
//
//            }
//        })
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
//        .subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer number) {
//                LogUtil.e("观察者的方法被调用了");
//                LogUtil.e("number: " + number);
//            }
//
//
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                LogUtil.e("onError...");
//            }
//        }, new Action0() {
//            @Override
//            public void call() {
//                LogUtil.e("onComplete...");
//            }
//        });
//==========================================================================================
//==========================================================================================
        // 变换功能
//        Observable.just(Environment.getExternalStorageDirectory().getAbsolutePath() + "/images/ic_icon.jpg")
//
//        .map(new Func1<String, Bitmap>() {
//            @Override
//            public Bitmap call(String filePath) {
//                LogUtil.e("Func1..." + filePath);
//                return getBitmapFromPath(filePath);
//            }
//        })
//        .subscribe(new Action1<Bitmap>() {
//            @Override
//            public void call(Bitmap bitmap) {
//                LogUtil.e("Action1...");
//                iv_icon.setImageBitmap(bitmap);
//            }
//        });


//    public Bitmap getBitmapFromPath(String path) {
//
//        if (!new File(path).exists()) {
//            System.err.println("getBitmapFromPath: file not exists");
//            return null;
//        }
//        // Bitmap bitmap = Bitmap.createBitmap(1366, 768, Config.ARGB_8888);
//        // Canvas canvas = new Canvas(bitmap);
//        // Movie movie = Movie.decodeFile(path);
//        // movie.draw(canvas, 0, 0);
//        //
//        // return bitmap;
//
//        byte[] buf = new byte[1024 * 1024];// 1M
//        Bitmap bitmap = null;
//
//        try {
//
//            FileInputStream fis = new FileInputStream(path);
//            int len = fis.read(buf, 0, buf.length);
//            bitmap = BitmapFactory.decodeByteArray(buf, 0, len);
//            if (bitmap == null) {
//                System.out.println("len= " + len);
//                System.err
//                        .println("path: " + path + "  could not be decode!!!");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//        return bitmap;
//    }
//==============================================================================
//==============================================================================
        // 变换问题
//        Student[] students = new Student[3];
//
//        for (int i = 0; i < 3; i++) {
//
//            Student s = new Student("范儿" + i, "计算机系" + i,null);
//            List<Course> courses = new ArrayList<Course>();
//
//            for (int j = 0;j < 3;j ++) {
//                Course course = new Course("" + j, "课程" + i + j);
//                courses.add(course);
//            }
//
//            s.setCourses(courses);
//            students[i] = s;
//        }
//
//        Observable.from(students)
//                .flatMap(new Func1<Student, Observable<Course>>() {
//            @Override
//            public Observable<Course> call(Student student) {
//                return Observable.from(student.getCourses());
//            }
//        })
//                .subscribe(new Subscriber<Course>() {
//            @Override
//            public void onCompleted() {
//                LogUtil.e("onCompleted...");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                LogUtil.e("onError...");
//            }
//
//            @Override
//            public void onNext(Course course) {
//                LogUtil.e("onNext...");
//                LogUtil.e("courseID：" + course.getCourseID() + ",courseName: " + course.getCourseName());
//            }
//        });
//=============================================================================================
//=============================================================================================

        // 线程控制2

        Observable.just(1,2)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.e("===============");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer num) {
                        LogUtil.e("number: " + num);
                    }
                });
    }


}
