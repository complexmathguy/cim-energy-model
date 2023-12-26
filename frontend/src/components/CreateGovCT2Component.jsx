import React, { Component } from 'react'
import GovCT2Service from '../services/GovCT2Service';

class CreateGovCT2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                aset: '',
                db: '',
                dm: '',
                flim1: '',
                flim10: '',
                flim2: '',
                flim3: '',
                flim4: '',
                flim5: '',
                flim6: '',
                flim7: '',
                flim8: '',
                flim9: '',
                ka: '',
                kdgov: '',
                kigov: '',
                kiload: '',
                kimw: '',
                kpgov: '',
                kpload: '',
                kturb: '',
                ldref: '',
                maxerr: '',
                minerr: '',
                mwbase: '',
                plim1: '',
                plim10: '',
                plim2: '',
                plim3: '',
                plim4: '',
                plim5: '',
                plim6: '',
                plim7: '',
                plim8: '',
                plim9: '',
                prate: '',
                r: '',
                rclose: '',
                rdown: '',
                ropen: '',
                rselect: '',
                rup: '',
                ta: '',
                tact: '',
                tb: '',
                tc: '',
                tdgov: '',
                teng: '',
                tfload: '',
                tpelec: '',
                tsa: '',
                tsb: '',
                vmax: '',
                vmin: '',
                wfnl: '',
                wfspd: ''
        }
        this.changeasetHandler = this.changeasetHandler.bind(this);
        this.changedbHandler = this.changedbHandler.bind(this);
        this.changedmHandler = this.changedmHandler.bind(this);
        this.changeflim1Handler = this.changeflim1Handler.bind(this);
        this.changeflim10Handler = this.changeflim10Handler.bind(this);
        this.changeflim2Handler = this.changeflim2Handler.bind(this);
        this.changeflim3Handler = this.changeflim3Handler.bind(this);
        this.changeflim4Handler = this.changeflim4Handler.bind(this);
        this.changeflim5Handler = this.changeflim5Handler.bind(this);
        this.changeflim6Handler = this.changeflim6Handler.bind(this);
        this.changeflim7Handler = this.changeflim7Handler.bind(this);
        this.changeflim8Handler = this.changeflim8Handler.bind(this);
        this.changeflim9Handler = this.changeflim9Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekdgovHandler = this.changekdgovHandler.bind(this);
        this.changekigovHandler = this.changekigovHandler.bind(this);
        this.changekiloadHandler = this.changekiloadHandler.bind(this);
        this.changekimwHandler = this.changekimwHandler.bind(this);
        this.changekpgovHandler = this.changekpgovHandler.bind(this);
        this.changekploadHandler = this.changekploadHandler.bind(this);
        this.changekturbHandler = this.changekturbHandler.bind(this);
        this.changeldrefHandler = this.changeldrefHandler.bind(this);
        this.changemaxerrHandler = this.changemaxerrHandler.bind(this);
        this.changeminerrHandler = this.changeminerrHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changeplim1Handler = this.changeplim1Handler.bind(this);
        this.changeplim10Handler = this.changeplim10Handler.bind(this);
        this.changeplim2Handler = this.changeplim2Handler.bind(this);
        this.changeplim3Handler = this.changeplim3Handler.bind(this);
        this.changeplim4Handler = this.changeplim4Handler.bind(this);
        this.changeplim5Handler = this.changeplim5Handler.bind(this);
        this.changeplim6Handler = this.changeplim6Handler.bind(this);
        this.changeplim7Handler = this.changeplim7Handler.bind(this);
        this.changeplim8Handler = this.changeplim8Handler.bind(this);
        this.changeplim9Handler = this.changeplim9Handler.bind(this);
        this.changeprateHandler = this.changeprateHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changercloseHandler = this.changercloseHandler.bind(this);
        this.changerdownHandler = this.changerdownHandler.bind(this);
        this.changeropenHandler = this.changeropenHandler.bind(this);
        this.changerselectHandler = this.changerselectHandler.bind(this);
        this.changerupHandler = this.changerupHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetactHandler = this.changetactHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetdgovHandler = this.changetdgovHandler.bind(this);
        this.changetengHandler = this.changetengHandler.bind(this);
        this.changetfloadHandler = this.changetfloadHandler.bind(this);
        this.changetpelecHandler = this.changetpelecHandler.bind(this);
        this.changetsaHandler = this.changetsaHandler.bind(this);
        this.changetsbHandler = this.changetsbHandler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
        this.changewfnlHandler = this.changewfnlHandler.bind(this);
        this.changewfspdHandler = this.changewfspdHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovCT2Service.getGovCT2ById(this.state.id).then( (res) =>{
                let govCT2 = res.data;
                this.setState({
                    aset: govCT2.aset,
                    db: govCT2.db,
                    dm: govCT2.dm,
                    flim1: govCT2.flim1,
                    flim10: govCT2.flim10,
                    flim2: govCT2.flim2,
                    flim3: govCT2.flim3,
                    flim4: govCT2.flim4,
                    flim5: govCT2.flim5,
                    flim6: govCT2.flim6,
                    flim7: govCT2.flim7,
                    flim8: govCT2.flim8,
                    flim9: govCT2.flim9,
                    ka: govCT2.ka,
                    kdgov: govCT2.kdgov,
                    kigov: govCT2.kigov,
                    kiload: govCT2.kiload,
                    kimw: govCT2.kimw,
                    kpgov: govCT2.kpgov,
                    kpload: govCT2.kpload,
                    kturb: govCT2.kturb,
                    ldref: govCT2.ldref,
                    maxerr: govCT2.maxerr,
                    minerr: govCT2.minerr,
                    mwbase: govCT2.mwbase,
                    plim1: govCT2.plim1,
                    plim10: govCT2.plim10,
                    plim2: govCT2.plim2,
                    plim3: govCT2.plim3,
                    plim4: govCT2.plim4,
                    plim5: govCT2.plim5,
                    plim6: govCT2.plim6,
                    plim7: govCT2.plim7,
                    plim8: govCT2.plim8,
                    plim9: govCT2.plim9,
                    prate: govCT2.prate,
                    r: govCT2.r,
                    rclose: govCT2.rclose,
                    rdown: govCT2.rdown,
                    ropen: govCT2.ropen,
                    rselect: govCT2.rselect,
                    rup: govCT2.rup,
                    ta: govCT2.ta,
                    tact: govCT2.tact,
                    tb: govCT2.tb,
                    tc: govCT2.tc,
                    tdgov: govCT2.tdgov,
                    teng: govCT2.teng,
                    tfload: govCT2.tfload,
                    tpelec: govCT2.tpelec,
                    tsa: govCT2.tsa,
                    tsb: govCT2.tsb,
                    vmax: govCT2.vmax,
                    vmin: govCT2.vmin,
                    wfnl: govCT2.wfnl,
                    wfspd: govCT2.wfspd
                });
            });
        }        
    }
    saveOrUpdateGovCT2 = (e) => {
        e.preventDefault();
        let govCT2 = {
                govCT2Id: this.state.id,
                aset: this.state.aset,
                db: this.state.db,
                dm: this.state.dm,
                flim1: this.state.flim1,
                flim10: this.state.flim10,
                flim2: this.state.flim2,
                flim3: this.state.flim3,
                flim4: this.state.flim4,
                flim5: this.state.flim5,
                flim6: this.state.flim6,
                flim7: this.state.flim7,
                flim8: this.state.flim8,
                flim9: this.state.flim9,
                ka: this.state.ka,
                kdgov: this.state.kdgov,
                kigov: this.state.kigov,
                kiload: this.state.kiload,
                kimw: this.state.kimw,
                kpgov: this.state.kpgov,
                kpload: this.state.kpload,
                kturb: this.state.kturb,
                ldref: this.state.ldref,
                maxerr: this.state.maxerr,
                minerr: this.state.minerr,
                mwbase: this.state.mwbase,
                plim1: this.state.plim1,
                plim10: this.state.plim10,
                plim2: this.state.plim2,
                plim3: this.state.plim3,
                plim4: this.state.plim4,
                plim5: this.state.plim5,
                plim6: this.state.plim6,
                plim7: this.state.plim7,
                plim8: this.state.plim8,
                plim9: this.state.plim9,
                prate: this.state.prate,
                r: this.state.r,
                rclose: this.state.rclose,
                rdown: this.state.rdown,
                ropen: this.state.ropen,
                rselect: this.state.rselect,
                rup: this.state.rup,
                ta: this.state.ta,
                tact: this.state.tact,
                tb: this.state.tb,
                tc: this.state.tc,
                tdgov: this.state.tdgov,
                teng: this.state.teng,
                tfload: this.state.tfload,
                tpelec: this.state.tpelec,
                tsa: this.state.tsa,
                tsb: this.state.tsb,
                vmax: this.state.vmax,
                vmin: this.state.vmin,
                wfnl: this.state.wfnl,
                wfspd: this.state.wfspd
            };
        console.log('govCT2 => ' + JSON.stringify(govCT2));

        // step 5
        if(this.state.id === '_add'){
            govCT2.govCT2Id=''
            GovCT2Service.createGovCT2(govCT2).then(res =>{
                this.props.history.push('/govCT2s');
            });
        }else{
            GovCT2Service.updateGovCT2(govCT2).then( res => {
                this.props.history.push('/govCT2s');
            });
        }
    }
    
    changeasetHandler= (event) => {
        this.setState({aset: event.target.value});
    }
    changedbHandler= (event) => {
        this.setState({db: event.target.value});
    }
    changedmHandler= (event) => {
        this.setState({dm: event.target.value});
    }
    changeflim1Handler= (event) => {
        this.setState({flim1: event.target.value});
    }
    changeflim10Handler= (event) => {
        this.setState({flim10: event.target.value});
    }
    changeflim2Handler= (event) => {
        this.setState({flim2: event.target.value});
    }
    changeflim3Handler= (event) => {
        this.setState({flim3: event.target.value});
    }
    changeflim4Handler= (event) => {
        this.setState({flim4: event.target.value});
    }
    changeflim5Handler= (event) => {
        this.setState({flim5: event.target.value});
    }
    changeflim6Handler= (event) => {
        this.setState({flim6: event.target.value});
    }
    changeflim7Handler= (event) => {
        this.setState({flim7: event.target.value});
    }
    changeflim8Handler= (event) => {
        this.setState({flim8: event.target.value});
    }
    changeflim9Handler= (event) => {
        this.setState({flim9: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekdgovHandler= (event) => {
        this.setState({kdgov: event.target.value});
    }
    changekigovHandler= (event) => {
        this.setState({kigov: event.target.value});
    }
    changekiloadHandler= (event) => {
        this.setState({kiload: event.target.value});
    }
    changekimwHandler= (event) => {
        this.setState({kimw: event.target.value});
    }
    changekpgovHandler= (event) => {
        this.setState({kpgov: event.target.value});
    }
    changekploadHandler= (event) => {
        this.setState({kpload: event.target.value});
    }
    changekturbHandler= (event) => {
        this.setState({kturb: event.target.value});
    }
    changeldrefHandler= (event) => {
        this.setState({ldref: event.target.value});
    }
    changemaxerrHandler= (event) => {
        this.setState({maxerr: event.target.value});
    }
    changeminerrHandler= (event) => {
        this.setState({minerr: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changeplim1Handler= (event) => {
        this.setState({plim1: event.target.value});
    }
    changeplim10Handler= (event) => {
        this.setState({plim10: event.target.value});
    }
    changeplim2Handler= (event) => {
        this.setState({plim2: event.target.value});
    }
    changeplim3Handler= (event) => {
        this.setState({plim3: event.target.value});
    }
    changeplim4Handler= (event) => {
        this.setState({plim4: event.target.value});
    }
    changeplim5Handler= (event) => {
        this.setState({plim5: event.target.value});
    }
    changeplim6Handler= (event) => {
        this.setState({plim6: event.target.value});
    }
    changeplim7Handler= (event) => {
        this.setState({plim7: event.target.value});
    }
    changeplim8Handler= (event) => {
        this.setState({plim8: event.target.value});
    }
    changeplim9Handler= (event) => {
        this.setState({plim9: event.target.value});
    }
    changeprateHandler= (event) => {
        this.setState({prate: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changercloseHandler= (event) => {
        this.setState({rclose: event.target.value});
    }
    changerdownHandler= (event) => {
        this.setState({rdown: event.target.value});
    }
    changeropenHandler= (event) => {
        this.setState({ropen: event.target.value});
    }
    changerselectHandler= (event) => {
        this.setState({rselect: event.target.value});
    }
    changerupHandler= (event) => {
        this.setState({rup: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetactHandler= (event) => {
        this.setState({tact: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetdgovHandler= (event) => {
        this.setState({tdgov: event.target.value});
    }
    changetengHandler= (event) => {
        this.setState({teng: event.target.value});
    }
    changetfloadHandler= (event) => {
        this.setState({tfload: event.target.value});
    }
    changetpelecHandler= (event) => {
        this.setState({tpelec: event.target.value});
    }
    changetsaHandler= (event) => {
        this.setState({tsa: event.target.value});
    }
    changetsbHandler= (event) => {
        this.setState({tsb: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }
    changewfnlHandler= (event) => {
        this.setState({wfnl: event.target.value});
    }
    changewfspdHandler= (event) => {
        this.setState({wfspd: event.target.value});
    }

    cancel(){
        this.props.history.push('/govCT2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovCT2</h3>
        }else{
            return <h3 className="text-center">Update GovCT2</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> aset: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dm: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flim9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kdgov: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kigov: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kiload: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kimw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpgov: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpload: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ldref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxerr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minerr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim10: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> plim9: </label>
                                            #formFields( $attribute, 'create')
                                            <label> prate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rclose: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rdown: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ropen: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rselect: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rup: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tact: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tdgov: </label>
                                            #formFields( $attribute, 'create')
                                            <label> teng: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tfload: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpelec: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tsa: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tsb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> wfnl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> wfspd: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovCT2}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateGovCT2Component
