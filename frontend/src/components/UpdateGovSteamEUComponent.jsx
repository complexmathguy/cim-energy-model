import React, { Component } from 'react'
import GovSteamEUService from '../services/GovSteamEUService';

class UpdateGovSteamEUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                chc: '',
                cho: '',
                cic: '',
                cio: '',
                db1: '',
                db2: '',
                hhpmax: '',
                ke: '',
                kfcor: '',
                khp: '',
                klp: '',
                kwcor: '',
                mwbase: '',
                pmax: '',
                prhmax: '',
                simx: '',
                tb: '',
                tdp: '',
                ten: '',
                tf: '',
                tfp: '',
                thp: '',
                tip: '',
                tlp: '',
                tp: '',
                trh: '',
                tvhp: '',
                tvip: '',
                tw: '',
                wfmax: '',
                wfmin: '',
                wmax1: '',
                wmax2: '',
                wwmax: '',
                wwmin: ''
        }
        this.updateGovSteamEU = this.updateGovSteamEU.bind(this);

        this.changechcHandler = this.changechcHandler.bind(this);
        this.changechoHandler = this.changechoHandler.bind(this);
        this.changecicHandler = this.changecicHandler.bind(this);
        this.changecioHandler = this.changecioHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changehhpmaxHandler = this.changehhpmaxHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfcorHandler = this.changekfcorHandler.bind(this);
        this.changekhpHandler = this.changekhpHandler.bind(this);
        this.changeklpHandler = this.changeklpHandler.bind(this);
        this.changekwcorHandler = this.changekwcorHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changeprhmaxHandler = this.changeprhmaxHandler.bind(this);
        this.changesimxHandler = this.changesimxHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetdpHandler = this.changetdpHandler.bind(this);
        this.changetenHandler = this.changetenHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetfpHandler = this.changetfpHandler.bind(this);
        this.changethpHandler = this.changethpHandler.bind(this);
        this.changetipHandler = this.changetipHandler.bind(this);
        this.changetlpHandler = this.changetlpHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetrhHandler = this.changetrhHandler.bind(this);
        this.changetvhpHandler = this.changetvhpHandler.bind(this);
        this.changetvipHandler = this.changetvipHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changewfmaxHandler = this.changewfmaxHandler.bind(this);
        this.changewfminHandler = this.changewfminHandler.bind(this);
        this.changewmax1Handler = this.changewmax1Handler.bind(this);
        this.changewmax2Handler = this.changewmax2Handler.bind(this);
        this.changewwmaxHandler = this.changewwmaxHandler.bind(this);
        this.changewwminHandler = this.changewwminHandler.bind(this);
    }

    componentDidMount(){
        GovSteamEUService.getGovSteamEUById(this.state.id).then( (res) =>{
            let govSteamEU = res.data;
            this.setState({
                chc: govSteamEU.chc,
                cho: govSteamEU.cho,
                cic: govSteamEU.cic,
                cio: govSteamEU.cio,
                db1: govSteamEU.db1,
                db2: govSteamEU.db2,
                hhpmax: govSteamEU.hhpmax,
                ke: govSteamEU.ke,
                kfcor: govSteamEU.kfcor,
                khp: govSteamEU.khp,
                klp: govSteamEU.klp,
                kwcor: govSteamEU.kwcor,
                mwbase: govSteamEU.mwbase,
                pmax: govSteamEU.pmax,
                prhmax: govSteamEU.prhmax,
                simx: govSteamEU.simx,
                tb: govSteamEU.tb,
                tdp: govSteamEU.tdp,
                ten: govSteamEU.ten,
                tf: govSteamEU.tf,
                tfp: govSteamEU.tfp,
                thp: govSteamEU.thp,
                tip: govSteamEU.tip,
                tlp: govSteamEU.tlp,
                tp: govSteamEU.tp,
                trh: govSteamEU.trh,
                tvhp: govSteamEU.tvhp,
                tvip: govSteamEU.tvip,
                tw: govSteamEU.tw,
                wfmax: govSteamEU.wfmax,
                wfmin: govSteamEU.wfmin,
                wmax1: govSteamEU.wmax1,
                wmax2: govSteamEU.wmax2,
                wwmax: govSteamEU.wwmax,
                wwmin: govSteamEU.wwmin
            });
        });
    }

    updateGovSteamEU = (e) => {
        e.preventDefault();
        let govSteamEU = {
            govSteamEUId: this.state.id,
            chc: this.state.chc,
            cho: this.state.cho,
            cic: this.state.cic,
            cio: this.state.cio,
            db1: this.state.db1,
            db2: this.state.db2,
            hhpmax: this.state.hhpmax,
            ke: this.state.ke,
            kfcor: this.state.kfcor,
            khp: this.state.khp,
            klp: this.state.klp,
            kwcor: this.state.kwcor,
            mwbase: this.state.mwbase,
            pmax: this.state.pmax,
            prhmax: this.state.prhmax,
            simx: this.state.simx,
            tb: this.state.tb,
            tdp: this.state.tdp,
            ten: this.state.ten,
            tf: this.state.tf,
            tfp: this.state.tfp,
            thp: this.state.thp,
            tip: this.state.tip,
            tlp: this.state.tlp,
            tp: this.state.tp,
            trh: this.state.trh,
            tvhp: this.state.tvhp,
            tvip: this.state.tvip,
            tw: this.state.tw,
            wfmax: this.state.wfmax,
            wfmin: this.state.wfmin,
            wmax1: this.state.wmax1,
            wmax2: this.state.wmax2,
            wwmax: this.state.wwmax,
            wwmin: this.state.wwmin
        };
        console.log('govSteamEU => ' + JSON.stringify(govSteamEU));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamEUService.updateGovSteamEU(govSteamEU).then( res => {
            this.props.history.push('/govSteamEUs');
        });
    }

    changechcHandler= (event) => {
        this.setState({chc: event.target.value});
    }
    changechoHandler= (event) => {
        this.setState({cho: event.target.value});
    }
    changecicHandler= (event) => {
        this.setState({cic: event.target.value});
    }
    changecioHandler= (event) => {
        this.setState({cio: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
    }
    changehhpmaxHandler= (event) => {
        this.setState({hhpmax: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfcorHandler= (event) => {
        this.setState({kfcor: event.target.value});
    }
    changekhpHandler= (event) => {
        this.setState({khp: event.target.value});
    }
    changeklpHandler= (event) => {
        this.setState({klp: event.target.value});
    }
    changekwcorHandler= (event) => {
        this.setState({kwcor: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changeprhmaxHandler= (event) => {
        this.setState({prhmax: event.target.value});
    }
    changesimxHandler= (event) => {
        this.setState({simx: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetdpHandler= (event) => {
        this.setState({tdp: event.target.value});
    }
    changetenHandler= (event) => {
        this.setState({ten: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetfpHandler= (event) => {
        this.setState({tfp: event.target.value});
    }
    changethpHandler= (event) => {
        this.setState({thp: event.target.value});
    }
    changetipHandler= (event) => {
        this.setState({tip: event.target.value});
    }
    changetlpHandler= (event) => {
        this.setState({tlp: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetrhHandler= (event) => {
        this.setState({trh: event.target.value});
    }
    changetvhpHandler= (event) => {
        this.setState({tvhp: event.target.value});
    }
    changetvipHandler= (event) => {
        this.setState({tvip: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changewfmaxHandler= (event) => {
        this.setState({wfmax: event.target.value});
    }
    changewfminHandler= (event) => {
        this.setState({wfmin: event.target.value});
    }
    changewmax1Handler= (event) => {
        this.setState({wmax1: event.target.value});
    }
    changewmax2Handler= (event) => {
        this.setState({wmax2: event.target.value});
    }
    changewwmaxHandler= (event) => {
        this.setState({wwmax: event.target.value});
    }
    changewwminHandler= (event) => {
        this.setState({wwmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamEUs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamEU</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> chc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> cho: </label>
                                            #formFields( $attribute, 'update')
                                            <label> cic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> cio: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> hhpmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kfcor: </label>
                                            #formFields( $attribute, 'update')
                                            <label> khp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> klp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kwcor: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> prhmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> simx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tdp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ten: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tfp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tip: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tlp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> trh: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tvhp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tvip: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wfmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wfmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wmax1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wmax2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wwmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> wwmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamEU}>Save</button>
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

export default UpdateGovSteamEUComponent
