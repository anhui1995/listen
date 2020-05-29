package xin.xiaoa.listen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class MainPlayerButton extends View {
    private Context context;
    /** 是否进行过了测量 */
    private boolean isMeasured = false;

    /** 未完成进度条的颜色 */
    private int paintUndoneColor = 0x5E5656;

    /** 未完成进度条的颜色 */
    private int paintUndoneColor2 = 0xff0000;

    /** 已完成进度条的颜色 */
    private int paintDoneColor = 0xDA2C35;




    /** 设置进度条画笔的宽度(px) */
    private int paintProgressWidthPx = 4;

    /** 设置进度条的边距(px) */
    private int paintProgressMarginPx = 20;


    /** 包围进度条圆弧的矩形 */
    private RectF rectF = new RectF();

    /** 画未完成进度圆弧的画笔 */
    private Paint paintUndone = new Paint();

    /** 画已经完成进度条的画笔 */
    private Paint paintDone = new Paint();

    /** 画中间按钮的画笔 */
    private Paint paintButton = new Paint();

    float ptsPause[] = new float[8];
    //float ptsPlay[] = new float[12];
    Path pathPlay = new Path();
    public MainPlayerButton(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public MainPlayerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public MainPlayerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }



    public void setPercent(int percent) {
       // this.percent = percent;
        /*isShown()：Returns the visibility of this view and all of its ancestors*/
//        if (isShown()) {
//            /*设置进度后重新开始一次动画*/
//            curTime=0;
//            this.invalidate();
//        }
    }

    public void setProgessColor(int mProgessColor) {
      //  this.mProgessColor = mProgessColor;
        if (isShown()) {
            this.invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!isMeasured) {
            getWidthAndHeight();
            isMeasured = true;
            System.out.println("getWidthAndHeight();得到视图等的高度宽度尺寸数据");
        }
        initData();
    }

    /** 得到视图等的高度宽度尺寸数据 */
    private void getWidthAndHeight() {

        // 得到自定义视图的高度
        int viewHeight;

        // 得到自定义视图的宽度
        int viewWidth;

        // 得到自定义视图的X轴中心点
        int viewCenterX;

        // 得到自定义视图的Y轴中心点
        int viewCenterY;

        viewHeight = getMeasuredHeight();
        viewWidth = getMeasuredWidth();
        viewCenterX = viewWidth / 2;
        viewCenterY = viewHeight / 2;


        //

        System.out.println("测量的数据");
        System.out.println("viewHeight"+viewHeight);
        System.out.println("viewWidth"+viewWidth);
        System.out.println("viewCenterX"+viewCenterX);
        System.out.println("viewCenterY"+viewCenterY);

        // 取本View长宽较小者的一半为整个圆环部分（包括圆环和文字）最外侧的半径
        int minLenth = viewHeight > viewWidth ? viewWidth / 2 : viewHeight / 2;


        // 得到圆环的中间半径（外径和内径平均值）
        int radiusArc = minLenth - paintProgressWidthPx / 2 - paintProgressMarginPx;

        rectF.left = viewCenterX - radiusArc ;
        rectF.top = viewCenterY - radiusArc ;
        rectF.right = viewCenterX + radiusArc ;
        rectF.bottom = viewCenterY + radiusArc;

        double x = 0.37;
        double y = 0.315;

        ptsPause[0] = (float) (rectF.left+(radiusArc*2)* x);
        ptsPause[1] = (float) (rectF.top+(radiusArc*2)* y);
        ptsPause[2] = (float) (rectF.left+(radiusArc*2)*x);
        ptsPause[3] = (float) (rectF.bottom-(radiusArc*2)*y);

        ptsPause[4] = (float) (rectF.right-(radiusArc*2)*x);
        ptsPause[5] = (float) (rectF.top+(radiusArc*2)*y);
        ptsPause[6] = (float) (rectF.right-(radiusArc*2)*x);
        ptsPause[7] = (float) (rectF.bottom-(radiusArc*2)*y);




        pathPlay.moveTo((float) (rectF.left +(radiusArc*2)* 0.4), (float) (rectF.top + (radiusArc*2)* 0.32));// 此点为多边形的起点
        pathPlay.lineTo((float) (rectF.left +(radiusArc*2)* 0.4), (float) (rectF.bottom-(radiusArc*2)* 0.32));
        pathPlay.lineTo((float) (rectF.right-(radiusArc*2)* 0.3), (rectF.top+radiusArc));
        pathPlay.close(); // 使这些点构成封闭的多边形


//        ptsPlay[0] = (float) (rectF.left+(radiusArc*2)* 0.4);
//        ptsPlay[1] = (float) (rectF.top+(radiusArc*2)* 0.32);
//
//        ptsPlay[2] = (float) (rectF.left+(radiusArc*2)* 0.4);
//        ptsPlay[3] = (float) (rectF.bottom-(radiusArc*2)* 0.32);
//
//        ptsPlay[6] = (float) (rectF.right-(radiusArc*2)* 0.3);
//        ptsPlay[7] =         (rectF.top+radiusArc);
//
//
//        ptsPlay[4] = ptsPlay[2];
//        ptsPlay[5] = ptsPlay[3];
//
//        ptsPlay[8] = ptsPlay[6];
//        ptsPlay[9] = ptsPlay[7];
//
//        ptsPlay[10] = ptsPlay[0];
//        ptsPlay[11] = ptsPlay[1];

        System.out.println("半径："+radiusArc*2);
        for (int i=0;i<4;i++){
            System.out.println("shuju :"+ptsPause[i]);
        }


    }


//    public void setCustomText(String mCustomText) {
//        this.mCustomText = mCustomText;
//    }
//
//    private Handler mHandler = new Handler();
//    private Runnable mAnimation = new Runnable() {
//        @Override
//        public void run() {
//            if (curTime < duration) {
//                curTime++;
//                /*导致重绘，调用onDraw，onDraw最后调用
//                 * mHandler.postDelayed(mAnimation, 20);更新进度条，界面重绘
//                 * 每次20毫秒，绘制10次，因此动画时间200毫秒*/
//                CustomCircleBar.this.invalidate();
//            }
//        }
//    };


    /** 初始化数据 */
    private void initData() {

        // 设置进度条画笔的宽度
//        paintProgressWidthPx = 10;


        // 未完成进度圆环的画笔的属性
        paintUndone.setColor(paintUndoneColor);
        paintUndone.setStrokeWidth(paintProgressWidthPx);

        paintUndone.setAntiAlias(true);
        paintUndone.setStyle(Paint.Style.STROKE);
        paintUndone.setAlpha(255);

        //paintDone.reset();

        // 已经完成进度条的画笔的属性
        paintDone.setColor(paintDoneColor);
        paintDone.setStrokeWidth(paintProgressWidthPx);
        paintDone.setStyle(Paint.Style.STROKE);
        paintDone.setAntiAlias(true);
        paintDone.setAlpha(255);

        /** 画中间按钮的画笔 */
        paintButton.setColor(paintUndoneColor);
        //paintButton.setColor(paintDoneColor);
        paintButton.setStrokeWidth(paintProgressWidthPx);
        paintButton.setStyle(Paint.Style.STROKE);
        paintButton.setAntiAlias(true);
        paintButton.setAlpha(255);
        paintButton.setStrokeWidth((float) 4.0);




    }


    private void init() {
        /*数据初始化，没有设置属性时候的默认值*/
//        percent = 0;
//        mProgessColor= Color.rgb(95,112,72);
//        mCustomText="Home";
        /*动态获取属性值*/
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.maintextclor, typedValue,true);
    }



    void drawButtonPause(Canvas canvas){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
      /* ❑ save：用来保存Canvas的状态。save之后，可以调用Canvas的平移、放缩、旋转、错切、裁剪等操作。
        restore：用来恢复Canvas之前保存的状态。防止save后对Canvas执行的操作对后续的绘制有影响。*/
        /*保存画布，绘制进度条*/
        canvas.save();


        canvas.drawArc(rectF, -0, 360, false, paintUndone);

        //             圆环           起始角度        圆环角度
        canvas.drawArc(rectF, -90, 100, false, paintDone);

        //画暂停按钮 paintButton ptsPlay
        //canvas.drawLines(ptsPause,0,8,paintButton);

        //canvas.drawLines(ptsPlay,0,12,paintButton);
        canvas.drawPath(pathPlay, paintButton);

        /*恢复画布*/
        canvas.restore();
       // CustomCircleBar.this.invalidate();
        //mHandler.postDelayed(mAnimation, 20);
    }



//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        float mWidth = getWidth();
//        float mHeight = getHeight();
//        /*下边是进度条画笔的设置*/
//        /** Restores the paint to its default settings. */
//        paintBar.reset();
//        /*圆环宽度4个像素*/
//        paintBar.setStrokeWidth(4);
//        /*空心圆环而非填充的额扇形*/
//        paintBar.setStyle(Paint.Style.STROKE);
//        paintBar.setAntiAlias(true);
//        paintBar.setColor(mProgessColor);
//        /*调整下不透明度，使边框弧和进度条区分开*/
//        paintBar.setAlpha(80);
//        /*接下来是文字画笔的设置*/
//        paintText.setTextSize(20);
//        paintText.setColor(paintDoneColor);
//        paintText.setStyle(Paint.Style.STROKE);
//        paintText.setAntiAlias(true);
//        /*从中间开始绘制文本*/
//        paintText.setTextAlign(Paint.Align.CENTER);
//        /*测量文字大小*/
//        Paint.FontMetrics fontMetrics = paintText.getFontMetrics();
//        /*计算文字高度*/
//        float textHeight = fontMetrics.bottom - fontMetrics.top;
//        /*计算圆的半径*/
//        float radius = Math.min(mWidth, mHeight) / 2 - 10;
//      /* ❑ save：用来保存Canvas的状态。save之后，可以调用Canvas的平移、放缩、旋转、错切、裁剪等操作。
//        restore：用来恢复Canvas之前保存的状态。防止save后对Canvas执行的操作对后续的绘制有影响。*/
//        /*保存画布，绘制进度条*/
//        canvas.save();
//        /*clipRect：该方法用于裁剪画布，也就是设置画布的显示区域
//        调用clipRect()方法后，只会显示被裁剪的区域，之外的区域将不会显示 */
//        canvas.clipRect(0, 0, mWidth, mHeight / 2 + radius - textHeight * 3 / 4);
//        /*因为clipRect的原因，外边的圆环下边留个缺口绘制文字*/
//        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, paintBar);
//
//        /*三角函数计算，下方缺口扇形的角度的一半*/
//        float theta_offset = (float) Math.acos((radius - textHeight / 2) / radius);
//        /*大弧围成的扇形的角度*/
//        float theta_full = 360 - 2 * theta_offset;
//        /*进度值围成的弧对应的角度*/
//        float thetaProcess = mDecelerateInterpolator.getInterpolation(1.0f * curTime / duration) * percent * theta_full / 100;
//        /*设置进度值颜色完全不透明*/
//        paintBar.setAlpha(255);
//        paintBar.setColor(mProgessColor);
//        /*注意弧形的起始角度，下边因显示文字导致圆环断开成一条弧，弧有左右两个端点，从左端点开始画弧*/
//        canvas.drawArc(new RectF(mWidth / 2 - radius, mHeight / 2 - radius, mWidth / 2 + radius, mHeight / 2 + radius), theta_offset+90, thetaProcess, false, paintBar);
//        /*恢复画布*/
//        canvas.restore();
//
//        mHandler.postDelayed(mAnimation, 20);
//    }
}