
package com.xiaofan.retrofit_okhttp_rxjava_demo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.Course;
import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.ParamBean;
import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.Student;
import com.xiaofan.retrofit_okhttp_rxjava_demo.bean.User;
import com.xiaofan.retrofit_okhttp_rxjava_demo.constant.Constant;
import com.xiaofan.retrofit_okhttp_rxjava_demo.util.LogUtil;

import java.io.File;
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
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
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

        //        testRetrofit();
//        testRxJavaFile();
//        testRxJavaGroupby();
//        testRxJavaMap();
//        testRxJavaWindow();
//        testRxJavaDistinct();
//        testRxJavaDebounce();
//        testRxJavaFilter();
//        testRxJavaOfType();
//        testRxJavaSingle();
//        testRxJavaSample();
//          testRxJavaTake();
//        testRxJavaCombine();
//        testRxJavaRetry();
//        testRxJavaRetryWhen();


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

//        Observable.just(1,2)
//                .subscribeOn(Schedulers.io())
//                .doOnSubscribe(new Action0() {
//                    @Override
//                    public void call() {
//                        progressBar.setVisibility(View.VISIBLE); // 需要在主线程执行
//                    }
//                })
//                .subscribeOn(AndroidSchedulers.mainThread()) // 指定主线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        LogUtil.e("===============");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer num) {
//                        LogUtil.e("number: " + num);
//                    }
//                });

//=============================================================================================
//=============================================================================================

        IApi iApi = retrofit.create(IApi.class);
        iApi.ajaxGetVerificationCode(new ParamBean("appTypeEnum_0","5006","83133333333"))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(User user) {

                        Schedulers.io().createWorker().schedule(new Action0() {
                            @Override
                            public void call() {
                                try {
                                    LogUtil.e("Thread name: " + Thread.currentThread().getName());
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                })
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError...");
                        LogUtil.e("error msg: " + e.getMessage());
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(User user) {
                        LogUtil.e("onSuccess..");
                        LogUtil.e("status: " + user.getStatus() + ",msg: " + user.getMsg());
                    }
                });

    }


    public void testRxJavaRetryWhen() {
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                System.out.println("subscribing");
                subscriber.onError(new RuntimeException("always fails"));
            }
        });

        observable.retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {

            @Override
            public Observable<?> call(Observable<? extends Throwable> observable) {

                return observable.zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Integer>() {
                    @Override
                    public Integer call(Throwable throwable, Integer integer) {
                        return integer / 0;
                    }
                }).flatMap(new Func1<Integer, Observable<?>>() {
                    @Override
                    public Observable<?> call(Integer integer) {
                        System.out.println("delay retry by " + integer + " second(s)");
                        //每一秒中执行一次
                        return Observable.timer(integer, TimeUnit.SECONDS);
                    }
                });
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Next:" + value);
            }
        });
    }


    public void testRxJavaRetry() {
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if (subscriber.isUnsubscribed()) return;
                //循环输出数字
                try {
                    for (int i = 0; i < 10; i++) {
                        if (i == 4) {
                            throw new Exception("this is number 4 error！");
                        }
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (Throwable e) {
                    subscriber.onError(e);
                }
            }
        });

        observable.retry(2).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("Next:" + value);
            }
        });
    }

    public void testRxJavaCombine() {
        //产生0,5,10,15,20数列
        Observable<Long> observable1 = Observable.timer(0, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 5;
                    }
                }).take(5);

        //产生0,10,20,30,40数列
        Observable<Long> observable2 = Observable.timer(500, 1000, TimeUnit.MILLISECONDS)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return aLong * 10;
                    }
                }).take(5);


        Observable.combineLatest(observable1, observable2, new Func2<Long, Long, Long>() {
            @Override
            public Long call(Long aLong, Long aLong2) {
                return aLong+aLong2;
            }
        }).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                System.out.println("Sequence complete.");
            }

            @Override
            public void onError(Throwable e) {
                System.err.println("Error: " + e.getMessage());
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("Next: " + aLong);
            }
        });
    }

    public void testRxJavaTake() {
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8)
                .take(9)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaSample() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    //前8个数字产生的时间间隔为1秒，后一个间隔为3秒
                    for (int i = 1; i < 9; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(1000);
                    }
                    Thread.sleep(2000);
                    subscriber.onNext(9);
                    subscriber.onCompleted();
                } catch(Exception e){
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .sample(2200, TimeUnit.MILLISECONDS)  //采样间隔时间为2200毫秒
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaSingle() {
        Observable.just(1,2,3,4,5,6,7,8,9,10)
                .single(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer integer) {
                        //取大于10的第一个数字
                        return integer>7;
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaOfType() {

        Observable.just(1, "hello world", true, 200L, 0.23f)
                .ofType(String.class)
                .subscribe(new Subscriber<Object>() {
                    @Override
                    public void onNext(Object item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaFilter() {
        Observable.just(1, 2, 3, 4, 5)
                .filter(new Func1<Integer, Boolean>() {
                    @Override
                    public Boolean call(Integer item) {
                        return item % 2 == 0;
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaDebounce() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(subscriber.isUnsubscribed()) return;
                try {
                    //产生结果的间隔时间分别为100、200、300...900毫秒
                    for (int i = 1; i < 10; i++) {
                        subscriber.onNext(i);
                        Thread.sleep(i * 100);
                    }
                    subscriber.onCompleted();
                }catch(Exception e){
                    subscriber.onError(e);
                }
            }
        }).subscribeOn(Schedulers.newThread())
                .debounce(400, TimeUnit.MILLISECONDS)  //超时时间为400毫秒
                .subscribe(
                        new Action1<Integer>() {
                            @Override
                            public void call(Integer integer) {
                                System.out.println("Next:" + integer);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                System.out.println("Error:" + throwable.getMessage());
                            }
                        }, new Action0() {
                            @Override
                            public void call() {
                                System.out.println("completed!");
                            }
                        });
    }

    public void testRxJavaDistinct() {
        Observable.just(1, 2, 1, 1, 2, 3)
                .distinct()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onNext(Integer item) {
                        System.out.println("Next: " + item);
                    }

                    @Override
                    public void onError(Throwable error) {
                        System.err.println("Error: " + error.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Sequence complete.");
                    }
                });
    }

    public void testRxJavaWindow() {
        Observable.interval(1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .subscribe(new Action1<Observable<Long>>() {
                    @Override
                    public void call(Observable<Long> observable) {
                        System.out.println("subdivide begin......");
                        observable.subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long aLong) {
                                System.out.println("Next:" + aLong);
                            }
                        });
                    }
                });
    }

    public void testRxJavaMap() {
        Observable.just(1,2,3,4,5,6).map(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                //对源Observable产生的结果，都统一乘以3处理
                return integer*3;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println("next:" + integer);
            }
        });
    }


    public void testRxJavaGroupby() {
        Observable.interval(1, TimeUnit.SECONDS).take(6).groupBy(new Func1<Long, Long>() {
            @Override
            public Long call(Long value) {
                //按照key为0,1,2分为3组
                return value % 3;
            }
        }).subscribe(new Action1<GroupedObservable<Long, Long>>() {
            @Override
            public void call(final GroupedObservable<Long, Long> result) {
                result.subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long value) {
                        System.out.println("key:" + result.getKey() +", value:" + value);
                    }
                });
            }
        });
    }

    // 遍历指定目录下的所有文件
    public void testRxJavaFile() {

        String path = Environment.getExternalStorageDirectory() + "/images/";

        Observable.just(new File(path))
                .concatMap(new Func1<File, Observable<File>>() {
                    @Override
                    public Observable<File> call(File file) {
                        //参数file是just操作符产生的结果，这里判断file是不是目录文件，如果是目录文件，则递归查找其子文件
                        // flatMap操作符神奇的地方在于，返回的结果还是一个Observable，而这个Observable其实是包含多个文件的Observable的，输出应该是ExternalCacheDir下的所有文件
                        return listFiles(file);
                    }
                })
                .subscribe(new Subscriber<File>() {
                    @Override
                    public void onCompleted() {
                        LogUtil.e("onCompleted...");
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError: " + e.getMessage());
                    }

                    @Override
                    public void onNext(File file) {
                        LogUtil.e("onNext: " + file.getAbsolutePath());
                    }
                });
    }

    private Observable<File> listFiles(final File f){
        if(f.isDirectory()){
            return Observable.from(f.listFiles()).concatMap(new Func1<File, Observable<File>>() {
                @Override
                public Observable<File> call(File file) {
                    return listFiles(file);
                }
            });
        } else {
            return Observable.just(f);
        }
    }



    public void testRetrofit() {
        IApi iApi = retrofit.create(IApi.class);
        iApi.ajaxGetVerificationCode(new ParamBean("appTypeEnum_0","5006","83133333333"))
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        progressBar.setVisibility(View.VISIBLE);
                        LogUtil.e("doOnSubscribe...");
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .retry(2)
                .doOnNext(new Action1<User>() {
                    @Override
                    public void call(User user) {

                        Schedulers.io().createWorker().schedule(new Action0() {
                            @Override
                            public void call() {
                                try {
                                    LogUtil.e("Thread name: " + Thread.currentThread().getName());
                                    Thread.sleep(2000);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                })
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtil.e("onError...");
                        LogUtil.e("error msg: " + e.getMessage());
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNext(User user) {
                        LogUtil.e("onSuccess..");
                        LogUtil.e("status: " + user.getStatus() + ",msg: " + user.getMsg());
                    }
                });
    }



}
