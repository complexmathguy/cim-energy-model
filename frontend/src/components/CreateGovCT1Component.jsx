import React, { Component } from 'react'
import GovCT1Service from '../services/GovCT1Service';

class CreateGovCT1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                aset: '',
                db: '',
                dm: '',
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
            GovCT1Service.getGovCT1ById(this.state.id).then( (res) =>{
                let govCT1 = res.data;
                this.setState({
                    aset: govCT1.aset,
                    db: govCT1.db,
                    dm: govCT1.dm,
                    ka: govCT1.ka,
                    kdgov: govCT1.kdgov,
                    kigov: govCT1.kigov,
                    kiload: govCT1.kiload,
                    kimw: govCT1.kimw,
                    kpgov: govCT1.kpgov,
                    kpload: govCT1.kpload,
                    kturb: govCT1.kturb,
                    ldref: govCT1.ldref,
                    maxerr: govCT1.maxerr,
                    minerr: govCT1.minerr,
                    mwbase: govCT1.mwbase,
                    r: govCT1.r,
                    rclose: govCT1.rclose,
                    rdown: govCT1.rdown,
                    ropen: govCT1.ropen,
                    rselect: govCT1.rselect,
                    rup: govCT1.rup,
                    ta: govCT1.ta,
                    tact: govCT1.tact,
                    tb: govCT1.tb,
                    tc: govCT1.tc,
                    tdgov: govCT1.tdgov,
                    teng: govCT1.teng,
                    tfload: govCT1.tfload,
                    tpelec: govCT1.tpelec,
                    tsa: govCT1.tsa,
                    tsb: govCT1.tsb,
                    vmax: govCT1.vmax,
                    vmin: govCT1.vmin,
                    wfnl: govCT1.wfnl,
                    wfspd: govCT1.wfspd
                });
            });
        }        
    }
    saveOrUpdateGovCT1 = (e) => {
        e.preventDefault();
        let govCT1 = {
                govCT1Id: this.state.id,
                aset: this.state.aset,
                db: this.state.db,
                dm: this.state.dm,
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
        console.log('govCT1 => ' + JSON.stringify(govCT1));

        // step 5
        if(this.state.id === '_add'){
            govCT1.govCT1Id=''
            GovCT1Service.createGovCT1(govCT1).then(res =>{
                this.props.history.push('/govCT1s');
            });
        }else{
            GovCT1Service.updateGovCT1(govCT1).then( res => {
                this.props.history.push('/govCT1s');
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
        this.props.history.push('/govCT1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovCT1</h3>
        }else{
            return <h3 className="text-center">Update GovCT1</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovCT1}>Save</button>
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

export default CreateGovCT1Component
