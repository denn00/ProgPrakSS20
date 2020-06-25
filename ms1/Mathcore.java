package ms1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Mathcore {
    public static final int STELLEN_INTERN = 200;
    public static final int STELLEN_OUTPUT = 30;
    public static final MathContext mc = new MathContext(STELLEN_INTERN, RoundingMode.HALF_EVEN);
    public static final MathContext mc_out = new MathContext(STELLEN_OUTPUT, RoundingMode.HALF_EVEN);
    public static final BigDecimal epsilon = BigDecimal.ONE.scaleByPowerOfTen(-(STELLEN_INTERN+1));
    public static final String PI =
            "3.141592653589793238462643383279502884197169399375105820974944592307816406286208" +
            "99862803482534211706798214808651328230664709384460955058223172535940812848111745" +
            "02841027019385211055596446229489549303819644288109756659334461284756482337867831" +
            "65271201909145648566923460348610454326648213393607260249141273724587006606315588" +
            "17488152092096282925409171536436789259036001133053054882046652138414695194151160" +
            "94330572703657595919530921861173819326117931051185480744623799627495673518857527" +
            "24891227938183011949129833673362440656643086021394946395224737190702179860943702" +
            "77053921717629317675238467481846766940513200056812714526356082778577134275778960" +
            "91736371787214684409012249534301465495853710507922796892589235420199561121290219" +
            "60864034418159813629774771309960518707211349999998372978049951059731732816096318" +
            "59502445945534690830264252230825334468503526193118817101000313783875288658753320" +
            "83814206171776691473035982534904287554687311595628638823537875937519577818577805" +
            "32171226806613001927876611195909216420198938095257201065485863278865936153381827" +
            "96823030195203530185296899577362259941389124972177528347913151557485724245415069" +
            "59508295331168617278558890750983817546374649393192550604009277016711390098488240" +
            "12858361603563707660104710181942955596198946767837449448255379774726847104047534" +
            "64620804668425906949129331367702898915210475216205696602405803815019351125338243" +
            "00355876402474964732639141992726042699227967823547816360093417216412199245863150" +
            "30286182974555706749838505494588586926995690927210797509302955321165344987202755" +
            "96023648066549911988183479775356636980742654252786255181841757467289097777279380" +
            "00816470600161452491921732172147723501414419735685481613611573525521334757418494" +
            "68438523323907394143334547762416862518983569485562099219222184272550254256887671" +
            "79049460165346680498862723279178608578438382796797668145410095388378636095068006" +
            "42251252051173929848960841284886269456042419652850222106611863067442786220391949" +
            "450471237137869609563643719172874677646575739624138908658326459958133904780275901";
    public static final String E =
            "2.718281828459045235360287471352662497757247093699959574966967627724076630353547" +
            "59457138217852516642742746639193200305992181741359662904357290033429526059563073" +
            "81323286279434907632338298807531952510190115738341879307021540891499348841675092" +
            "44761460668082264800168477411853742345442437107539077744992069551702761838606261" +
            "33138458300075204493382656029760673711320070932870912744374704723069697720931014" +
            "16928368190255151086574637721112523897844250569536967707854499699679468644549059" +
            "87931636889230098793127736178215424999229576351482208269895193668033182528869398" +
            "49646510582093923982948879332036250944311730123819706841614039701983767932068328" +
            "23764648042953118023287825098194558153017567173613320698112509961818815930416903" +
            "51598888519345807273866738589422879228499892086805825749279610484198444363463244" +
            "96848756023362482704197862320900216099023530436994184914631409343173814364054625" +
            "31520961836908887070167683964243781405927145635490613031072085103837505101157477" +
            "04171898610687396965521267154688957035035402123407849819334321068170121005627880" +
            "23519303322474501585390473041995777709350366041699732972508868769664035557071622" +
            "68447162560798826517871341951246652010305921236677194325278675398558944896970964" +
            "09754591856956380236370162112047742722836489613422516445078182442352948636372141" +
            "74023889344124796357437026375529444833799801612549227850925778256209262264832627" +
            "79333865664816277251640191059004916449982893150566047258027786318641551956532442" +
            "58698294695930801915298721172556347546396447910145904090586298496791287406870504" +
            "89585867174798546677575732056812884592054133405392200011378630094556068816674001" +
            "69842055804033637953764520304024322566135278369511778838638744396625322498506549" +
            "95886234281899707733276171783928034946501434558897071942586398772754710962953741" +
            "52111513683506275260232648472870392076431005958411661205452970302364725492966693" +
            "81151373227536450988890313602057248176585118063036442812314965507047510254465011" +
            "727211555194866850800368532281831521960037356252794495158284188294787610852639814";
    public static BigDecimal add(BigDecimal x, BigDecimal y) {
        BigDecimal result = x;
        result = result.add(y, mc);
        return result;
    }
    public static BigDecimal sub(BigDecimal x, BigDecimal y) {
        BigDecimal result = y;
        result = result.subtract(x, mc);
        return result;
    }
    public static BigDecimal mul(BigDecimal x, BigDecimal y) {
        BigDecimal result = x;
        result = result.multiply(y, mc);
        return result;
    }
    public static BigDecimal div(BigDecimal x, BigDecimal y) throws ArithmeticException {
        if (y.compareTo(BigDecimal.ZERO)==0) throw new ArithmeticException("Division by zero");
        BigDecimal divide = y.divide(x, mc);
        return divide;
    }
    public static BigDecimal fak(BigDecimal x) throws ArithmeticException {
        if (x.compareTo(BigDecimal.ZERO) < 0)
            throw new ArithmeticException("Invalid argument");
        try {
            int f = x.intValueExact();
        } catch (ArithmeticException ex){
            throw new ArithmeticException("Invalid argument");
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i =1 ; i<=x.intValueExact(); i++){
            result = mul(result, new BigDecimal(i));
        }
        return result;
    }
    public static BigDecimal exp(BigDecimal x) {
        int b = 0;
        if (x.compareTo(BigDecimal.ZERO)==0){
            return BigDecimal.ONE;
        }
        while ((x.abs()).compareTo(BigDecimal.TEN.pow(b,mc))>=0){
            b++;
        }

        BigDecimal a = x.divide(BigDecimal.TEN.pow(b,mc));
        BigDecimal r = BigDecimal.ZERO;
        BigDecimal k = BigDecimal.ZERO;
        while (new BigDecimal(E).divide(fak(k.add(BigDecimal.ONE,mc)),mc).compareTo(epsilon)>=0){
            r=r.add((a.pow(k.intValueExact(),mc)).divide(fak(k),mc),mc);
            k=k.add(BigDecimal.ONE,mc);
        }
        while (b>0){
            r=r.pow(10,mc);
            b--;
        }
        return r;
    }
    public static BigDecimal ln(BigDecimal x) throws ArithmeticException {
        if (x.compareTo(BigDecimal.ZERO)<=0) throw new ArithmeticException("Invalid argument");
        BigDecimal a = x;
        int w = 0;
        while ((((BigDecimal.ONE.subtract(a,mc)).abs()).compareTo(new BigDecimal(0.1,mc)))>=0){
            a=a.sqrt(mc);
            w++;
        }
        BigDecimal r = BigDecimal.ZERO;
        BigDecimal k = BigDecimal.ZERO;
        BigDecimal two = BigDecimal.ONE.multiply(BigDecimal.valueOf(2),mc);
        BigDecimal nenner1 = new BigDecimal(180,mc);
        BigDecimal nenner2 = new BigDecimal(String.valueOf((two.multiply(k,mc)).add(new BigDecimal(3),mc)));
        BigDecimal nenner3 = new BigDecimal(19, mc).pow(2*k.intValueExact()+1,mc);
        while(BigDecimal.ONE.divide(((nenner1.multiply(nenner2,mc)).multiply(nenner3,mc)),mc).compareTo(epsilon)>=0){
            r=r.add(new BigDecimal(String.valueOf(two.divide((two.multiply(k,mc)).add(BigDecimal.ONE,mc),mc))).multiply(((a.subtract(BigDecimal.ONE,mc)).divide(a.add(BigDecimal.ONE,mc),mc)).pow(2*k.intValueExact()+1,mc),mc),mc);
            k=k.add(BigDecimal.ONE,mc);
            nenner3 = new BigDecimal(19, mc).pow(2*k.intValueExact()+1,mc);
        }
        while (w>0){
            r=r.multiply(two,mc);
            w--;
        }
        return r;
    }
    public static BigDecimal pot(BigDecimal a, BigDecimal b) {
        if (b.compareTo(BigDecimal.ZERO) < 0)
            throw new ArithmeticException("Cannot power negative");
        else if (a.compareTo(BigDecimal.ZERO) == 0)
            return BigDecimal.ZERO;
        BigDecimal result = exp(a.multiply(ln(b),mc));
        return result;
    }
    public static BigDecimal root(BigDecimal a, BigDecimal b) {
        if (a.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Die Wurzelfunktion erlaubt nur Zahlen >= 0 als Radikand");
        }
        if (b.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Die Wurzelfunktion erlaubt nur Zahlen >0 als Wurzelexponent");
        }
        return pot(b,BigDecimal.ONE.divide(a, mc));
    }
    public static BigDecimal sin(BigDecimal x) {
        BigDecimal a = x.remainder(new BigDecimal(2).multiply(new BigDecimal(PI), mc), mc);
        if (a.compareTo(new BigDecimal(PI, mc))>0 && a.compareTo(new BigDecimal(2).multiply(new BigDecimal(PI), mc))<0) {
            a.subtract(new BigDecimal(2).multiply(new BigDecimal(PI), mc));
        } else if (a.compareTo(new BigDecimal(PI, mc))==0){
            return BigDecimal.ZERO;
        }
        BigDecimal r = BigDecimal.ZERO;
        int k=0;
        BigDecimal m = (BigDecimal.ONE).negate(mc);
        while (((new BigDecimal(PI, mc).pow(2*k+3,mc)).divide(fak(new BigDecimal(2*k+3)),mc)).compareTo(epsilon)>=0){
            r=r.add((m.pow(k,mc)).multiply(((a.pow(2*k+1,mc)).divide(fak(new BigDecimal(2*k+1)),mc)),mc));
            k++;
        }
        return r;
    }
    public static BigDecimal cos(BigDecimal x){
        return sin((new BigDecimal(PI,mc).divide(new BigDecimal(2),mc)).subtract(x,mc));
    }
    public static BigDecimal tan(BigDecimal x) {
        if (cos(x).compareTo(BigDecimal.ZERO)==0) throw new ArithmeticException("Cosinus ist negativ");
        return sin(x).divide(cos(x),mc);
    }

}

