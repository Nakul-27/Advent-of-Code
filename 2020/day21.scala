// Prepare yourself... This one took a lot of brain power and a lot of time. Not the longest, however it was time consuming and my brain hurts a lot after doing just Part 1.
// Part 2 i need to think about more, so I'll revist that later.
object Day21 {
//   val input = """
// mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
// trh fvjkl sbzzf mxmxvkd (contains dairy)
// sqjhc fvjkl (contains soy)
// sqjhc mxmxvkd sbzzf (contains fish)
// """.trim
   val input = """
 xfvxzl nfcrh kscdhn khnqq jkvcbf jhlvrg chc fk zbh hgrptqb zrvtg tdhv jhqpdf jvjhx rrmlg mxsklfx vzn tmp hrhg fpcstf zgpv pdpgm cbsvx ttkn bkmgx xknj bxfvt bdccss tqjg mkpmkx fhpm kcgtlb ktrkfn schkf gcbbnqb sfb rjnx hcms cjt qhhsj qddlrq flnhl vxzpfp tplrt bnl ddmg mxbbst (contains shellfish, sesame)
 vxzpfp shlg zrvtg ghq vzn ppqs mqlnbjq cltpv pvxpgp psbnqz nqcmm sqjcsxjq xftxgfj glxxp rrmlg fczfjr phsr dccscx mxlzjfr skrrb flnhl rzlkxt rdrzjqh vjbgmpr tfgf pvx jbcjk chc pqnx pdpgm dlzpmb mkpmkx sbhdb szdxjlb ttkn ljpzx kvrtf ccvzk fjsq sfb xflfx qgs gcsjjf xfpc gkfzqvc hgrptqb cdslv rzlbs tzrp rjnx fk phfmh kbgx brdx qhhsj qtgv ktrkfn fhpm msrnhf cbhfpzp khnqq dhqbf (contains fish)
 fzhmtds zbclt pbln qtgv bnl xqcb vxzpfp jkvcbf nnst tplrt xknj hzmvzrr xfvxzl gkddl dqz brdx tqjg hgrptqb pvxpgp cdslv kgrld mdqlbx nv lsngc phfmh ttkn bxfvt ftkfc njtfs tlgchbh xhb vbvfr flnhl qrnxd tmp djldkx kkcm xfpc ghq ktrkfn lvdcdg strd mkpmkx vtdbl pdpgm xknh kbgx hctgkpd (contains sesame, fish, shellfish)
 ghq vfqh vtdbl bkmgx bxlc sbhdb xfvxzl lvdcdg nsktq hrjrm dbr prrfm dbqbv jbcjk mkpmkx njtfs flnhl nfsrv lfmng fhznhmx rmxzzf msrnhf nqcmm ghzx pdpgm dzqs dhqbf mqlnbjq ktrkfn mxsklfx gbplfj gcsjjf ttkn dvzqx vxpbn jrpx cbsvx kbgx sfpc cpp jvjhx tzrp qhhsj cdslv zrvtg gmtkh txr rzlbs sqjcsxjq dlzpmb bxfvt tmp qddlrq fjsq hzmvzrr xsnrd cmqrqcf dqz qgs nhjbd jgpgql dpkkzdgs cjds (contains nuts)
 xknj bbbzcmh tzrp xkqgc ktfvb tplrt dqz ntq jbcjk pcnmbt nqcmm tlgchbh bxfvt nfsrv kcgtlb ckpjgb rzlkxt tgcvz fczfjr frv dzqs sqjcsxjq jhqpdf schkf mmdfrfcp phfmh bxlc kscdhn rjnx cdslv vbvfr bkhjxl cjdnjf ccvzk cjds gcbbnqb lgtvqf ttkn vfqh pvx cljvdxp gbplfj mkpmkx tqjg lfmng xfpc cbhfpzp nv jgpgql tmp gkgzn cltpv skrrb gcsjjf frgm vzn kbgx xsnrd szdxjlb pqnx pdpgm rmxzzf xflfx qddlrq hzmvzrr sfpc znkr cpp jrpx prrfm cmqrqcf zrvtg lnmv xftxgfj vxzpfp ksrh xknh ssbldv bkmgx lsngc glxxp jhlvrg fhznhmx (contains dairy, soy)
 strd dpdgc cjdnjf flmssjn xfpc mmdfrfcp gpp tqjg znkr mxbbst bbbzcmh jbvrzn cdslv mxlzjfr txr cbsvx dvzqx vtdbl xflfx fczfjr tgcvz cjt nfcrh bkmgx prrfm tjj lgtvqf lfmng rrmlg vzn pbln rdrzjqh kkcm qqbfj kgrld cbhfpzp tdsvx hcms phsr vxpbn gkgzn sfb jsdgn szdxjlb flnhl vfqh vnxgpb dpkkzdgs bxfvt xfvxzl pdpgm xknj qhhsj tmp zrvtg xttdqc khnm ddmg fzhmtds hzpsn zhpv cfbgb vxzpfp jvjhx kcgtlb nnst ttkn sfpc jhqpdf gkddl xhb ghq fhznhmx xknh schkf (contains soy, wheat)
 gkgzn bndz dpkkzdgs nv nhjbd mqlnbjq khnqq ljpzx cfbgb xknj ddmg mkpmkx tgcvz nnst szdxjlb sqjcsxjq tmp bnl znkr mxbbst nfcrh mxsklfx qqlm ttkn vxzpfp gmtkh pqnx kpxcvj gpp qhhsj ftkfc glxxp vzn dccscx jrj xqcb zrvtg hhvh phfmh cjdnjf vtdbl hctgkpd phsr rjnx cjds qddlrq pvrhpt vjbgmpr vbvfr gcsjjf kbgx hrhg kgrld ksrh nfsrv qqmjlr tjj ccvzk xsnrd hzmvzrr hrjrm pbln qgs zbh bxfvt dqxjx cdslv kkcm fjsq xfpc ktfvb cbsvx rzlkxt ckpjgb bkhjxl pdpgm strd tdhv fk tdsvx (contains sesame)
 gnfjcpc ddmg tpbtpd cltpv xfvxzl txr rmxzzf tgcvz jsdgn pgnk jrpx vbvfr vzn gbplfj xqcb bxfvt fk hzpsn qtgv xbksdv cljvdxp dpdgc lnmv rjnx ttkn prrfm ccvzk hctgkpd dlzpmb dhqbf zgpv ghzx gkddl dqrvvk qrnxd flnhl gkgzn vnxgpb pvrhpt lfmng mkpmkx pqnx cjdnjf gmtkh sfpc mxbbst fpcstf dnbhhv cjds dqz tzrp vtdbl jhlvrg kvrtf pdpgm cjt tmp qddlrq fhznhmx xsnrd flmssjn brdx sfb dpkkzdgs djldkx gpp nhjbd nv psbnqz cdslv frv dbr bxlc xfpc dvzqx hcms zrvtg (contains dairy)
 pdpgm dlzpmb flnhl drgdhp jbvrzn xssjz njtfs phsr spclmfb tqjg nhjbd ssbldv prrfm xflfx tjj ljpzx msrnhf bxfvt kbgx xfvxzl fjsq khnqq dpkkzdgs vjbgmpr cjds fhznhmx ppqs vxpbn qhhsj bdccss bnl ttkn fzhmtds bxlc nqcmm hzpsn vtdbl dqrvvk gcbz psbnqz dbr cbsvx tmp pcnmbt lffhf xbksdv sfpc djldkx gpp xknh rdrzjqh skrrb kpxcvj flmssjn zrvtg gkddl cljvdxp pqnx bbbzcmh xfpc lvdcdg vxzpfp ntq cdslv jrj hrjrm fpcstf qqlm sfb pvxpgp (contains sesame, soy)
 txr ghq rmxzzf tmp ttkn vxpbn brdx gcbz zbclt hctgkpd khnqq dlzpmb cljvdxp nfsrv kkcm mkpmkx nv tgcvz xbksdv ntq rdrzjqh jbvrzn flmssjn qhhsj bbbzcmh sbhdb tplrt hzpsn ghzx qtgv gcbbnqb flnhl rrmlg vjbgmpr ktfvb dhqbf xfpc cdslv cbhfpzp xhb xttdqc dvzqx hrjrm qgs glxxp ldggb bdccss pdpgm cjds xknh frgm tfgf fzhmtds sqjcsxjq fk ncqd ksrh zrvtg (contains peanuts, wheat)
 psbnqz hcms gkddl kgrld dccscx txr tjj ddmg vxzpfp jvjhx qqmjlr bndz mkpmkx brdx gpp jbvrzn gnfjcpc bxlc qqlm flnhl gcsjjf sfb nsktq pbln xttdqc qtgv ccvzk kkcm jkvcbf ttkn vnxgpb ktrkfn dbqbv msrnhf rjnx qqbfj bbbzcmh cljvdxp zrvtg dqz cbsvx xhb xflfx shlg ktfvb nnst ghzx mxsklfx khnqq sqjcsxjq prrfm rdrzjqh xkqgc cbhfpzp mxlzjfr vfqh fjsq dnbhhv rzlbs tmp cdslv jhlvrg fzhmtds qddlrq dpdgc ldggb bkmgx bdccss ghq rrmlg frgm fczfjr pcnmbt lvdcdg qhhsj ftkfc tgcvz mqlnbjq nqcmm cmqrqcf phfmh xqcb drgdhp nv mxbbst znkr (contains peanuts)
 hrhg dbqbv mkpmkx gnfjcpc drgdhp cpp nfcrh rjnx cdslv ttkn xssjz khnqq ftkfc qqbfj hcms strd gcbz pvx cfbgb dqz hctgkpd kpxcvj jrpx txr vzn ghzx rzlbs pvxpgp xknh nv xknj pdpgm dqxjx gmtkh vjbgmpr skrrb mxbbst pvrhpt tlgchbh bkhjxl sbhdb frv ssbldv fhznhmx tdhv xbksdv tjj dzqs zrvtg nqcmm ghq dpkkzdgs ntq cbsvx glxxp mxsklfx pqnx vbvfr tplrt tmp vxpbn pgnk xfpc xhb cbhfpzp prrfm flnhl mxlzjfr phsr gkddl cjt gbplfj gkgzn sfpc (contains shellfish)
 jhlvrg xflfx bxlc hrhg dvzqx zrvtg ghq pdpgm jgpgql ppqs cfbgb rzlbs ccvzk fhpm ttkn xsnrd gkddl mkpmkx jkvcbf vxzpfp bxfvt tfgf lsngc vtdbl mpc sfb jhqpdf dnbhhv cjdnjf vjbgmpr xhb txr hzpsn gpp cjds fk qhhsj fjsq sfpc cpp cdslv pbln khnqq psbnqz lfmng phfmh dccscx nfsrv jbcjk sbhdb hrjrm flnhl fpcstf hgrptqb qqmjlr rdrzjqh cbhfpzp gcbbnqb (contains wheat)
 bdccss txr flmssjn fk ccvzk jbvrzn nqcmm vjbgmpr lnmv tmp dccscx xbksdv vzn dvzqx ghzx jrj xfvxzl dbqbv jhlvrg fczfjr rmxzzf vxzpfp fhznhmx hrhg kcgtlb dzqs kkcm psbnqz jbcjk bxfvt skrrb phfmh mxbbst ncqd shlg khnqq zrvtg hzmvzrr jsdgn kgrld kscdhn vxpbn pdpgm ftkfc vtdbl mkpmkx ttkn zbh cdslv cbhfpzp qgs sbhdb ddmg tpbtpd nfsrv mpc brdx njtfs (contains peanuts, soy)
 jbcjk dqz schkf znkr tfgf pcnmbt lnmv kkcm rzlbs lgtvqf kvrtf bxlc zrvtg cltpv shlg ccvzk spclmfb pvxpgp dzqs ghq cjds flnhl xssjz xfvxzl kscdhn vxzpfp psbnqz pdpgm khnm nsktq tmp bdccss hgrptqb dnbhhv vtdbl msrnhf kbgx pvx mkpmkx cmqrqcf lvdcdg cdslv qddlrq qrnxd xhb rdrzjqh jgpgql fhznhmx (contains shellfish, nuts, peanuts)
 bxlc kgrld bkhjxl pgnk flmssjn rzlkxt khnqq tplrt phsr prrfm lgtvqf tzrp zbh frv tmp dqz cfbgb skrrb mxsklfx txr mkpmkx jkvcbf xsnrd vxpbn xkqgc ssbldv nsktq ntq mdqlbx vxzpfp pdpgm ghzx hgrptqb gpp flnhl mpc shlg dbqbv cdslv nnst zrvtg jhqpdf xttdqc mmdfrfcp pqnx zbclt sbhdb rmxzzf mqlnbjq gkfzqvc (contains shellfish)
 ddmg ksrh jsdgn hrhg djldkx mkpmkx kcgtlb cmqrqcf cbhfpzp qtgv kvrtf shlg frv vzn glxxp sfb ccvzk zbclt bxfvt gnfjcpc dqxjx cdslv xftxgfj vbvfr pvrhpt jbvrzn xkqgc mpc dhqbf spclmfb vjbgmpr fhpm xssjz drgdhp jhlvrg cfbgb nv qhhsj flnhl vxzpfp ttkn ldggb psbnqz ntq lffhf gkfzqvc cbsvx tmp prrfm njtfs hhvh xqcb ssbldv pcnmbt pdpgm (contains fish, shellfish)
 rzlbs gbplfj cbsvx sfpc cljvdxp xftxgfj xhb jbcjk tgcvz gcbz bxlc txr ksrh ttkn fhpm nfsrv qhhsj ssbldv cjdnjf bbbzcmh kgrld nv ktrkfn skrrb pvxpgp mqlnbjq sfb ddmg dqxjx dqz vxpbn mdqlbx jbvrzn ktfvb dnbhhv glxxp bkmgx tfgf dvzqx tdsvx cdslv kcgtlb hrhg frgm tmp ghq pdpgm hctgkpd vfqh brdx rjnx znkr kscdhn vxzpfp xknh fhznhmx jrj lsngc mkpmkx cjds gkddl tzrp sbhdb dpdgc xttdqc xflfx zrvtg ppqs flmssjn (contains nuts)
 qhhsj nqcmm chc rrmlg cjds bndz bdccss ljpzx vxzpfp glxxp bxlc fk rzlkxt mmdfrfcp ntq flnhl rjnx tmp lnmv nfcrh ttkn dqxjx hrhg cmqrqcf lvdcdg phsr zrvtg gpqdxvv cdslv qgs vtdbl khnm jkvcbf gkgzn phfmh dpdgc gkfzqvc mpc ftkfc txr xfpc tdhv kkcm xqcb fpcstf gcsjjf hzmvzrr gcbz fhpm dvzqx msrnhf vzn fzhmtds pdpgm mqlnbjq sfpc cfbgb qqmjlr strd nsktq nv zgpv (contains dairy, sesame, soy)
 ktrkfn rrmlg nfcrh gbplfj rjnx ssbldv nv rzlkxt hrhg tplrt xttdqc ghzx sqjcsxjq ckpjgb lvdcdg msrnhf pqnx bbbzcmh mxsklfx gkfzqvc gnfjcpc kcgtlb cdslv jhqpdf lsngc bdccss qhhsj xflfx tmp jsdgn dpdgc vbvfr qrnxd dzqs dbqbv zrvtg jrpx zhpv sfpc hhvh ncqd sbhdb tdsvx dlzpmb phfmh ccvzk xbksdv nnst pdpgm ttkn flnhl mkpmkx dpkkzdgs (contains dairy, shellfish)
 hcms lfmng ljpzx vxzpfp pbln pvrhpt phfmh qgs skrrb vzn mkpmkx bndz hzmvzrr tmp cbsvx gnfjcpc hzpsn jhqpdf gkfzqvc lgtvqf pdpgm hrjrm bxlc ttkn cbhfpzp cljvdxp jvjhx tlgchbh zhpv zgpv xbksdv dnbhhv txr cmqrqcf tpbtpd tzrp glxxp cdslv xhb jgpgql nhjbd lnmv dlzpmb prrfm dhqbf flnhl tdsvx (contains soy, sesame, shellfish)
 qqbfj ccvzk cjds tdhv fhznhmx xftxgfj xknj kscdhn ktfvb kvrtf prrfm gkddl hzpsn gmtkh lgtvqf xfvxzl xttdqc hrhg bnl ljpzx dqxjx njtfs zbclt dqz ntq dccscx pdpgm nsktq gkgzn bdccss cfbgb pvrhpt tplrt ssbldv vtdbl zrvtg txr chc bkhjxl drgdhp ddmg mxlzjfr glxxp fk xfpc dhqbf gcbbnqb mxbbst vxzpfp cdslv dlzpmb bbbzcmh gcbz skrrb hrjrm zhpv qtgv hcms nhjbd qqlm cmqrqcf hgrptqb qgs ftkfc psbnqz xkqgc tmp gnfjcpc mpc mkpmkx ttkn mdqlbx tlgchbh ldggb brdx (contains dairy)
 cjds mxsklfx frv qtgv phsr dpkkzdgs ddmg hrjrm hzmvzrr shlg dhqbf ftkfc nfsrv dlzpmb fhpm tdhv xsnrd tdsvx lgtvqf rzlbs nnst msrnhf cljvdxp djldkx xfvxzl kkcm xknj xhb tplrt vxzpfp dnbhhv qqlm rzlkxt hcms ttkn ppqs khnm bbbzcmh tmp pbln qrnxd phfmh gcbbnqb zrvtg ksrh pcnmbt nsktq flnhl lnmv tpbtpd gmtkh ldggb gkgzn ckpjgb pvx cmqrqcf jrpx szdxjlb pdpgm zbh jbcjk dpdgc nv khnqq dbqbv cdslv (contains nuts, peanuts)
 kgrld zrvtg rjnx jrj mxlzjfr xftxgfj gkfzqvc nnst gnfjcpc fczfjr pvrhpt xhb fzhmtds frv tgcvz tlgchbh xqcb xbksdv dpkkzdgs tmp cjdnjf mdqlbx bbbzcmh pvx ljpzx tjj gcbbnqb hrjrm bkmgx sbhdb glxxp cfbgb cdslv xknh pbln ckpjgb dqz rmxzzf flnhl dlzpmb vbvfr mkpmkx pdpgm cjt vxpbn ttkn kpxcvj znkr qhhsj kscdhn dqrvvk xsnrd sfb (contains shellfish, sesame)
 mxbbst tgcvz xbksdv chc gkfzqvc dzqs vxzpfp ksrh qddlrq vtdbl gpp vfqh mxsklfx znkr mkpmkx kpxcvj rdrzjqh ddmg glxxp hhvh rmxzzf dpkkzdgs qtgv xhb zbclt xsnrd pvx cmqrqcf skrrb ghzx bkhjxl tplrt dqrvvk cltpv kgrld cdslv qqmjlr pbln hzpsn gpqdxvv nv dlzpmb kvrtf dvzqx tfgf hctgkpd ttkn jgpgql dbqbv phfmh bkmgx dccscx jvjhx tmp ktrkfn qqlm jrpx gcsjjf qqbfj bndz nfsrv pdpgm ssbldv cjds gcbbnqb xfvxzl vbvfr ljpzx xknh lgtvqf zbh tdhv kkcm frv shlg nqcmm tlgchbh djldkx lvdcdg zrvtg gnfjcpc vzn cfbgb qhhsj zhpv fzhmtds fk xqcb tqjg nnst (contains soy)
 jrj rjnx vbvfr nv vnxgpb rmxzzf qgs mkpmkx bbbzcmh xftxgfj gpp hgrptqb kcgtlb qqmjlr vzn zbclt jhqpdf hrjrm vjbgmpr tgcvz ldggb ssbldv ttkn cjdnjf kbgx kscdhn jgpgql jrpx xknh pdpgm bkmgx dbqbv frv schkf hhvh qrnxd nfcrh tplrt glxxp skrrb vxzpfp pvxpgp fhpm tdsvx bxlc cpp rzlbs ckpjgb tmp cjt pvrhpt nhjbd xsnrd bkhjxl strd dqrvvk gcbbnqb gkgzn xfvxzl nqcmm bxfvt tqjg zrvtg cmqrqcf ntq zgpv frgm tfgf fjsq xhb lsngc qqlm xknj fzhmtds khnm cjds flnhl kgrld (contains fish, shellfish, dairy)
 lfmng psbnqz xknj gkddl cmqrqcf mkpmkx mxlzjfr bkmgx tgcvz pcnmbt vxzpfp tplrt mmdfrfcp khnqq vfqh cjdnjf gpqdxvv ttkn lvdcdg bdccss zbclt tmp kscdhn sqjcsxjq hzpsn flnhl flmssjn cjds xftxgfj xssjz brdx xkqgc pdpgm cfbgb qhhsj skrrb phfmh pvrhpt cdslv tlgchbh fk dnbhhv tzrp mqlnbjq jgpgql nqcmm (contains wheat, fish, nuts)
 ddmg djldkx pdpgm txr vzn dnbhhv sfpc zrvtg fhznhmx lfmng hrjrm ntq zbclt bdccss xfpc ttkn tjj pcnmbt cmqrqcf fzhmtds qhhsj xkqgc xssjz cdslv nv flnhl mxlzjfr ckpjgb cltpv kpxcvj jrpx hgrptqb xhb sqjcsxjq ktfvb xqcb zhpv kbgx kcgtlb cjds rdrzjqh jgpgql lnmv mkpmkx lvdcdg cfbgb lsngc nfcrh rzlkxt ktrkfn tmp tfgf (contains wheat, nuts, fish)
 fczfjr dvzqx zgpv dqxjx hhvh bnl glxxp tlgchbh qrnxd ghq tfgf kscdhn gmtkh flnhl msrnhf tqjg qddlrq qqmjlr rzlkxt cpp schkf tdhv xqcb vzn khnqq fk xttdqc tmp nsktq hzpsn kvrtf frv hcms fpcstf szdxjlb qqbfj tjj dlzpmb dbqbv qtgv cdslv jhlvrg hgrptqb flmssjn rdrzjqh zrvtg njtfs xknj cjds mxsklfx ncqd pqnx gpqdxvv shlg jbcjk mkpmkx xhb vxzpfp ttkn jvjhx kpxcvj mxbbst fzhmtds jrj bxfvt vfqh (contains shellfish, wheat)
 nsktq gkgzn mmdfrfcp ttkn zhpv gkfzqvc rzlbs znkr sbhdb nqcmm dqxjx bndz xflfx frgm ncqd lvdcdg jbvrzn dbqbv zrvtg lsngc qgs lgtvqf cdslv khnm tmp qddlrq xbksdv jkvcbf strd bbbzcmh kscdhn spclmfb ljpzx pqnx hzpsn cltpv mkpmkx skrrb pbln vxzpfp hgrptqb tgcvz ntq mxbbst ckpjgb bdccss cmqrqcf tzrp fk gbplfj tpbtpd pvxpgp hhvh qqmjlr tplrt qrnxd mxsklfx hzmvzrr pdpgm dhqbf xftxgfj khnqq ccvzk bkmgx nv (contains peanuts, dairy)
 vfqh mkpmkx vxzpfp hrjrm kpxcvj ghzx dqz lfmng zrvtg pvxpgp flnhl gpqdxvv dpkkzdgs tdsvx dbr cbsvx kcgtlb xfpc mmdfrfcp jvjhx fhznhmx tmp msrnhf xflfx mxsklfx gbplfj tqjg tdhv vtdbl nv drgdhp bndz znkr xttdqc pdpgm ttkn mxbbst rmxzzf pbln lffhf lsngc tgcvz qgs fpcstf szdxjlb sfpc xsnrd hctgkpd cljvdxp rrmlg cmqrqcf ntq sbhdb qrnxd djldkx dvzqx tjj kbgx hgrptqb rzlkxt nfsrv xkqgc lgtvqf jsdgn vbvfr (contains soy)
 szdxjlb zrvtg qqlm kcgtlb lgtvqf gkgzn jvjhx xkqgc ssbldv flmssjn xttdqc ktfvb nqcmm cbhfpzp qrnxd cdslv sfpc gkddl chc jsdgn dlzpmb rzlkxt tqjg cjt vxzpfp tfgf xknj msrnhf tzrp kkcm ttkn flnhl pvrhpt mxsklfx skrrb nv tmp frgm hrhg hrjrm qtgv dpkkzdgs xftxgfj fjsq gcsjjf mkpmkx vnxgpb (contains sesame, dairy, nuts)
 vbvfr psbnqz jgpgql ktrkfn nsktq dpkkzdgs lffhf kvrtf nv gkgzn gcbz bbbzcmh ktfvb pgnk mmdfrfcp vfqh mqlnbjq ttkn cljvdxp fhpm bxfvt sbhdb hrjrm jbvrzn qtgv vxpbn qrnxd tdhv cpp dnbhhv hhvh zrvtg xbksdv tgcvz xsnrd gnfjcpc frgm cltpv kkcm cdslv kscdhn dqz bkmgx tjj rjnx fk pdpgm mdqlbx drgdhp dpdgc jrj hcms dbr jsdgn strd qqlm lsngc tmp bxlc sfpc chc jvjhx jrpx nhjbd flnhl fjsq mkpmkx gkddl tqjg xknh (contains peanuts)
 tpbtpd psbnqz mxbbst bndz vxzpfp pbln qqbfj chc cfbgb dpkkzdgs qtgv gmtkh mkpmkx lffhf strd ghq rzlkxt vfqh mqlnbjq cjt flnhl ntq ppqs drgdhp mmdfrfcp gpqdxvv bkhjxl zgpv ftkfc jrj tjj cljvdxp gcbbnqb zrvtg sfpc ttkn kcgtlb tdsvx tqjg ktfvb tgcvz dbqbv cdslv xkqgc nsktq skrrb tzrp sqjcsxjq xftxgfj dqrvvk znkr dnbhhv pdpgm (contains sesame, shellfish)
 lffhf cljvdxp hzmvzrr mdqlbx hrjrm nfcrh njtfs bnl tgcvz xqcb cbhfpzp ktfvb brdx khnqq mpc zrvtg lgtvqf qhhsj mqlnbjq jbvrzn bdccss nhjbd dnbhhv txr msrnhf cjds kvrtf gmtkh dhqbf qqlm xttdqc ftkfc cmqrqcf mxsklfx gnfjcpc xsnrd sfpc dbqbv qrnxd pgnk flnhl jgpgql znkr tpbtpd jrj dqrvvk bxlc zbh mxlzjfr skrrb vnxgpb bkmgx kcgtlb vxzpfp zhpv dccscx drgdhp ljpzx pdpgm gbplfj ccvzk tmp gcbbnqb ssbldv tplrt lnmv vzn dqxjx mxbbst ghq hrhg mkpmkx vxpbn dlzpmb nnst ttkn pvrhpt gcsjjf ddmg vfqh (contains shellfish)
 dqrvvk mxbbst ftkfc vjbgmpr dnbhhv fjsq pgnk xkqgc ccvzk fhznhmx cltpv gkddl jsdgn zbh vxzpfp fhpm gmtkh sbhdb kgrld lgtvqf kkcm tlgchbh qqbfj tmp zrvtg lfmng ssbldv chc xftxgfj bdccss tdsvx znkr ddmg fczfjr mdqlbx vzn dccscx xsnrd bbbzcmh cdslv xfvxzl szdxjlb bndz hrjrm drgdhp ncqd rdrzjqh mkpmkx kscdhn glxxp dbr xfpc pdpgm fpcstf hcms flnhl qtgv cpp gnfjcpc nhjbd qqmjlr jgpgql ldggb sfb bxlc (contains nuts)
 xknj psbnqz tzrp vxzpfp gmtkh mxlzjfr jsdgn lgtvqf kpxcvj glxxp tplrt ttkn djldkx dqxjx pvx gpp vbvfr dccscx cdslv hcms sqjcsxjq ktfvb dbqbv dpkkzdgs kgrld dqrvvk vzn flnhl bdccss mqlnbjq pbln lffhf tmp mxsklfx frv sfb xhb mkpmkx shlg brdx pdpgm lfmng dlzpmb tqjg ldggb hzmvzrr (contains dairy, wheat)
 tmp cdslv cljvdxp rrmlg lffhf hgrptqb pgnk brdx dqrvvk dqz schkf szdxjlb bxfvt pbln vxzpfp dpkkzdgs mqlnbjq xssjz sbhdb msrnhf pvrhpt xsnrd cmqrqcf nfcrh sfb cbhfpzp phfmh tqjg chc jbcjk tplrt qhhsj ttkn bndz pdpgm rmxzzf ldggb mkpmkx ghzx khnqq vzn xkqgc kkcm zrvtg ckpjgb dnbhhv dzqs ghq hzpsn jkvcbf tpbtpd bkhjxl strd rzlbs hcms tjj fhznhmx jbvrzn xbksdv jgpgql phsr (contains fish, soy, nuts)
 nsktq ftkfc mdqlbx bxfvt vtdbl djldkx cljvdxp cpp ghzx sbhdb ppqs dvzqx zhpv kgrld hcms jsdgn cjdnjf flnhl dzqs dqz nfcrh mkpmkx sfpc dpkkzdgs xttdqc xftxgfj frv qgs hgrptqb vxzpfp ghq zrvtg bndz cdslv gkfzqvc sfb kscdhn pbln tmp kcgtlb gnfjcpc cfbgb ckpjgb tgcvz nhjbd pgnk xknj skrrb jkvcbf pcnmbt hrjrm glxxp cbhfpzp sqjcsxjq hzmvzrr xhb mxlzjfr bxlc qrnxd qqmjlr jhlvrg khnqq drgdhp pvrhpt gmtkh qqbfj psbnqz tpbtpd vjbgmpr ttkn shlg pvx fzhmtds fk mxbbst rmxzzf rrmlg pvxpgp tjj zbclt kpxcvj kvrtf nnst dqrvvk (contains peanuts)
 fhznhmx khnm skrrb ckpjgb glxxp rzlkxt jrj mxsklfx mdqlbx mkpmkx xhb bkhjxl ttkn flnhl njtfs vfqh dqxjx pqnx xfpc cdslv sfb xbksdv zrvtg jvjhx zbclt pvx xsnrd lgtvqf kbgx ntq pbln xttdqc sfpc lffhf spclmfb gpqdxvv qqlm jbcjk rdrzjqh dlzpmb mqlnbjq kkcm tdsvx tmp nv vtdbl gkddl znkr xknh fczfjr djldkx brdx tfgf gmtkh pdpgm dpdgc fpcstf bndz kgrld tdhv frv pcnmbt drgdhp dpkkzdgs fk jbvrzn xfvxzl gnfjcpc pvrhpt ktrkfn cmqrqcf vzn phfmh gkgzn kscdhn txr zgpv (contains fish, shellfish)
 cbhfpzp tmp rjnx dpdgc frv xflfx dbr fzhmtds kcgtlb msrnhf khnm hgrptqb tfgf xssjz hhvh bnl ncqd qgs vxzpfp xfpc zrvtg mqlnbjq sfpc ppqs cdslv phsr vnxgpb fhznhmx bbbzcmh pvxpgp tzrp ttkn xqcb dhqbf dzqs ljpzx bkhjxl djldkx gkddl lsngc cljvdxp hctgkpd dccscx xfvxzl vbvfr tjj lnmv ssbldv tgcvz kgrld ccvzk cbsvx xkqgc qddlrq qtgv nqcmm mxsklfx pgnk dpkkzdgs jgpgql lvdcdg drgdhp tdsvx dbqbv gnfjcpc xftxgfj qrnxd ckpjgb ftkfc fhpm flnhl nv cjdnjf sfb rrmlg qqmjlr pdpgm nfsrv dvzqx cjds jhlvrg spclmfb qhhsj (contains sesame, nuts, soy)
 flnhl gkddl jhqpdf jkvcbf xqcb gcbbnqb ddmg ppqs bnl jrpx cdslv bxlc tfgf msrnhf strd vxzpfp jsdgn kcgtlb cljvdxp glxxp pvx prrfm qqmjlr drgdhp tmp jrj zrvtg rmxzzf zhpv vnxgpb ldggb ksrh rzlkxt qqbfj lnmv njtfs vjbgmpr pdpgm tpbtpd vxpbn dzqs dnbhhv dpkkzdgs dqz cbhfpzp djldkx mqlnbjq gkfzqvc lfmng pqnx jvjhx gmtkh jbcjk dvzqx pgnk szdxjlb ttkn dqrvvk cltpv (contains wheat, nuts)
 """.trim

  // Regex Cheatsheet: https://regexcheatsheet.com
  // Regex: {One or more words} (contains {{one or more words with a comma} zero or more times.})
  // Probably could've been an easier way to do it, but it works.
  val foodRegex = """([\w ]+)\(contains ([\w, ]+)*\)""".r

  // We could make a type for the Recipies, but we could also make a case class.
  // And this way we can use the case class specific features that Scala offers.
  case class Food(ingredients: List[String], allergens: List[String])

  // What I think that we want is a (Hash?)Map.
  // In this Map, the key will be the allergen and the values will be the ingredients that contain said allergen.
  // From here, we can get the sum by finding the number of times that any of those ingredients appear from said Map.
  // *time passed*
  // I did not read the ingredients and while I got the right value for the test output, I did not get the right output for the actual values.
  // We will revisit this tomorrow.
  
  def getMap(foods: List[Food]): Map[String, Set[String]] = {
    // THOUGHT PROCESS FOR THIS ONE:
    // A Good spot for For Comprehension?
    // Let's give it a shot.
    // Did some research on For Comprehension and stumbled upon this article on different symbolic operators in Scala.
    // Article: https://stackoverflow.com/questions/7888944/what-do-all-of-scalas-symbolic-operators-mean
    // Also after watching a Talk by the creator of Scala Martin Ordesky, I heard that implicits are the most popular feature in Scala.
    // After doing some research I found this article on Implicits: https://apiumhub.com/tech-blog-barcelona/scala-implicits/
    // The Arrow Operator means implicit conversions: https://docs.scala-lang.org/tutorials/FAQ/finding-symbols.html
    // Using this knowledge, my thought process for getting the Map is that we can create a List of Tuples (_1,_2).
    // _1 of the Tuple will be the allergen. 
    // _2 of the Tuple will be a List of the ingredients that have that allergen for each Food.
    // From here we need to find a way to match up the _1 in the List of Tuples. 
    // We can use these match ups to see which _2 are in all of the _1.
    // *time passes*
    // Reglecting on Day 6, I remember using the built in reduce function of Scala's Sets.
    // Perhaps we can use it in a manner like "reduce{_ & _}," like we used in day 6.
    // Of course we would need to convert to a set, however that is trivial.
    // Our end goal is a Map, so we might have to rethink our process.
    // Thinking about reduce and maps, I did some more research. 
    // All of this is quite new to me, so I'm glad that I'm getting exposed to it.
    // That being said, it will take some time for me to become fully familiar with it.
    // Here's what I found: https://blog.genuine.com/2019/11/scalas-groupmap-and-groupmapreduce/
    // This article talks about groupBy and groupMap, which can convert List and things of the sort into Maps.
    // That isn't all though... If we use groupMapReduce, we can groupMap and reduce at the same time.
    // What it does is it "compartmentalized the functions for the keys, values, and reduction operation separately."
    // Pretty wild honestly. I'm digging these built in scala features.
    
    val tuplesList = for {
      // We take each element of the List[Food] and extract each Food case class from it.
      Food(ingredients, allergens) <- foods
      // Get each allergen from the List of Allergens (since allergen is List[String])
      allergen <- allergens
      // "yield allergen -> ingredients" means that we can use implicits to create a list of the allergens and the associated ingredients.
      // Did not know about this until now. 
      // Quite a good feature.
    } yield allergen -> ingredients 

    // After trial and error, here's what I arrived with for the groupMapReduce function.
    // Update: Could not reduce with a List, so we needed to convert the List of Ingredients to a Set.
    tuplesList.groupMapReduce(_._1)(_._2.toSet)(_ & _)
  }

  object Part1 {
    // Now from here we need to iterator over the tuplesList and find the number of elements that appear in the value of each key and sum them.
    // Works for the example.
    // I did not read the directions yet again and need to revise.
    // *a night passes*
    // Ok after some thought and deliberation, I believe that  have arrived at a Solution that works with some examples in the REPL.
    // Hope is not lost... We'll take what we had done before, with tuplesList.
    // From here, we can create another List: A List of all of the ingredients.
    // Now the interesting part... On one of the days (I forget which one), I explored the possibility of using a '++' between sets operator in Scala.
    // So I went to the Scala REPL and cht.sh created an example:
    // "curl cht.sh/scala/++" is the command that I used to look up the '++' operator.
    // > val s = List(1,2,3,4,5)
    // > val w = List(1,3,5,7,9)
    // > s.toSet ++ w.toSet
    // val res94: scala.collection.immutable.Set[Int] = HashSet(5, 1, 9, 2, 7, 3, 4)
    // So I looked at that and thought that there must be a '--' operator, however order must matter, because order matters for subtraction.
    // So I went back to the REPL (same values):
    // > s -- w
    // error value -- is not a member of List[Int]
    // So I had to turn them into sets:
    // > s.toSet -- w.toSet
    // val res99: scala.collection.immutable.Set[Int] = HashSet(2, 4)
    // > w.toSet -- s.toSet
    // val res100: scala.collection.immutable.Set[Int] = HashSet(9, 7)
    // So order does matter, but this brings me back to discrete math last year, more formally the part of Set Theory we learned.
    // It looks as though this operator takes two sets and finds the elements of the first set that do not appear in the second set.
    // I.E: s.toSet -- w.toSet returns the elements of s that are not in w.
    // Side Note: Thinking about this now, it makes sense that you need to convert the lists into Sets, because the operator is part of SET Theory haha.
    // Also you can use the '++' operator with lists, but not the '--' because Sets cannot contain duplicates,
    // and allowing '--' to be used with Sets opens the door up for complications with respect to if elements appear more than once.
    // Now that we've gone over the '--' operator, this is how we're going to use it:
    // 1) We're going to take what we created above with the getMap function and get the values from it and then flatten it so that way we have one Set of values.
    // 2) We're going to take the output of parseInput and get all of the ingredients from us using map and flatten.
    // (Alternatively you could use flatMap, as this is what it was designed for, but I've already used that in a problem, so I figured "let's just use map and then flatten")
    // 3) We're going to take the List from 2, convert it to a Set, take the Set (to use '--' and get rid of any duplicates) from 1, and use the -- operator.
    // 3 cont'd) This will give us the the ingredients in 2 that are not in 1 (and 1 is all of the possible allergens).
    // 3.1) It'll look something like this (output of 2) -- (output of 1)
    // 4) We will then need to cross reference this list with the original list of ingredients from the original list of food and see what elements appear and how many times they appear.
    // 5) The size of 4 will give us what we desire.

    def findSum(input: String): Int = {
      val parsedInput = parseInput(input)
      // Step 1
      val part1 = getMap(parsedInput).values.flatten
      // Step 2
      val part2 = parsedInput.map(_.ingredients).flatten.toSet
      // Step 3
      val ingredientsToCount: Set[String] = (part2 -- part1).toSet

      // Step 4
      // This gets the ingredients from teh original list of food.
      val crossReference: List[String] = parsedInput.map(_.ingredients).flatten
      
      // Step 5
      // The size of this will give us what we desire.
      getFinalListToCount(ingredientsToCount, crossReference).size
      
      // We don't want to convert final list to a set because there are multiple ingredients that show up more than once.
    }
  }

  // Part 2 did not work... I'll revisit later.
  // TODO: Finish Part 2.
  // object Part2 {
  //   def canonicalDangerousIngredientsList(input: String): List[String] = {
  //     val parsedInput = parseInput(input)
  //     val part1 = getMap(parsedInput).values.flatten
  //     val part2 = parsedInput.map(_.ingredients).flatten.toSet
  //     val ingredientsList: Set[String] = (part2 -- part1).toSet

  //     val crossReference: List[String] = parsedInput.map(_.ingredients).flatten

  //     // Here we want a set because we want to eliminate duplicates.
  //     // We can then turn it back to a List to use the sorted function to get the alphabetical order.
  //     // Article: https://alvinalexander.com/scala/how-sort-scala-sequences-seq-list-array-buffer-vector-ordering-ordered/
  //     (for {
  //       ingredient <- crossReference
  //       if (!ingredientsList.contains(ingredient)) 
  //     } yield ingredient.trim).toSet.toList
  //                                   .sorted
  //                                   .filter(_ != "")
  //   }
  // }

  def getFinalListToCount(ingredientsList: Set[String], crossReference: List[String]): List[String] = {
    for {
      ingredient <- crossReference
      if (ingredientsList.contains(ingredient)) 
    } yield ingredient
  }
  // As always, parse the input.
  // This time we split it into each line and then we put each line through the regex.
  // From there we create a Food with the first part of the regex is teh intredients and the second, the allergens.
  // Of course, for the ingredients and allergens, we need to a tad bit of cleaning up.
  def parseInput(s: String): List[Food] = {
    s.split("\n").map{ case foodRegex(ingredients, allergens) => {
      Food(ingredients.split(" ").map(x => x.trim()).toList, allergens.split(",").map(x => x.trim).toList)
    } }.toList
  }

  def main(args: Array[String]): Unit = {
    println(s"Day 21, Part1: ${Part1.findSum(input)}")
    // TODO: Fix Part 2
    // println(s"Day 21, Part2: ${Part2.canonicalDangerousIngredientsList(input)}")
    // println("Hello World")
  }
}
