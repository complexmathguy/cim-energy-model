import React, { Component } from 'react'
import GovSteamFV4Service from '../services/GovSteamFV4Service';

class UpdateGovSteamFV4Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                cpsmn: '',
                cpsmx: '',
                crmn: '',
                crmx: '',
                kdc: '',
                kf1: '',
                kf3: '',
                khp: '',
                kic: '',
                kip: '',
                kit: '',
                kmp1: '',
                kmp2: '',
                kpc: '',
                kpp: '',
                kpt: '',
                krc: '',
                ksh: '',
                lpi: '',
                lps: '',
                mnef: '',
                mxef: '',
                pr1: '',
                pr2: '',
                psmn: '',
                rsmimn: '',
                rsmimx: '',
                rvgmn: '',
                rvgmx: '',
                srmn: '',
                srmx: '',
                srsmp: '',
                svmn: '',
                svmx: '',
                ta: '',
                tam: '',
                tc: '',
                tcm: '',
                tdc: '',
                tf1: '',
                tf2: '',
                thp: '',
                tmp: '',
                trh: '',
                tv: '',
                ty: '',
                y: '',
                yhpmn: '',
                yhpmx: '',
                ympmn: '',
                ympmx: ''
        }
        this.updateGovSteamFV4 = this.updateGovSteamFV4.bind(this);

        this.changecpsmnHandler = this.changecpsmnHandler.bind(this);
        this.changecpsmxHandler = this.changecpsmxHandler.bind(this);
        this.changecrmnHandler = this.changecrmnHandler.bind(this);
        this.changecrmxHandler = this.changecrmxHandler.bind(this);
        this.changekdcHandler = this.changekdcHandler.bind(this);
        this.changekf1Handler = this.changekf1Handler.bind(this);
        this.changekf3Handler = this.changekf3Handler.bind(this);
        this.changekhpHandler = this.changekhpHandler.bind(this);
        this.changekicHandler = this.changekicHandler.bind(this);
        this.changekipHandler = this.changekipHandler.bind(this);
        this.changekitHandler = this.changekitHandler.bind(this);
        this.changekmp1Handler = this.changekmp1Handler.bind(this);
        this.changekmp2Handler = this.changekmp2Handler.bind(this);
        this.changekpcHandler = this.changekpcHandler.bind(this);
        this.changekppHandler = this.changekppHandler.bind(this);
        this.changekptHandler = this.changekptHandler.bind(this);
        this.changekrcHandler = this.changekrcHandler.bind(this);
        this.changekshHandler = this.changekshHandler.bind(this);
        this.changelpiHandler = this.changelpiHandler.bind(this);
        this.changelpsHandler = this.changelpsHandler.bind(this);
        this.changemnefHandler = this.changemnefHandler.bind(this);
        this.changemxefHandler = this.changemxefHandler.bind(this);
        this.changepr1Handler = this.changepr1Handler.bind(this);
        this.changepr2Handler = this.changepr2Handler.bind(this);
        this.changepsmnHandler = this.changepsmnHandler.bind(this);
        this.changersmimnHandler = this.changersmimnHandler.bind(this);
        this.changersmimxHandler = this.changersmimxHandler.bind(this);
        this.changervgmnHandler = this.changervgmnHandler.bind(this);
        this.changervgmxHandler = this.changervgmxHandler.bind(this);
        this.changesrmnHandler = this.changesrmnHandler.bind(this);
        this.changesrmxHandler = this.changesrmxHandler.bind(this);
        this.changesrsmpHandler = this.changesrsmpHandler.bind(this);
        this.changesvmnHandler = this.changesvmnHandler.bind(this);
        this.changesvmxHandler = this.changesvmxHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetamHandler = this.changetamHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetcmHandler = this.changetcmHandler.bind(this);
        this.changetdcHandler = this.changetdcHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changethpHandler = this.changethpHandler.bind(this);
        this.changetmpHandler = this.changetmpHandler.bind(this);
        this.changetrhHandler = this.changetrhHandler.bind(this);
        this.changetvHandler = this.changetvHandler.bind(this);
        this.changetyHandler = this.changetyHandler.bind(this);
        this.changeyHandler = this.changeyHandler.bind(this);
        this.changeyhpmnHandler = this.changeyhpmnHandler.bind(this);
        this.changeyhpmxHandler = this.changeyhpmxHandler.bind(this);
        this.changeympmnHandler = this.changeympmnHandler.bind(this);
        this.changeympmxHandler = this.changeympmxHandler.bind(this);
    }

    componentDidMount(){
        GovSteamFV4Service.getGovSteamFV4ById(this.state.id).then( (res) =>{
            let govSteamFV4 = res.data;
            this.setState({
                cpsmn: govSteamFV4.cpsmn,
                cpsmx: govSteamFV4.cpsmx,
                crmn: govSteamFV4.crmn,
                crmx: govSteamFV4.crmx,
                kdc: govSteamFV4.kdc,
                kf1: govSteamFV4.kf1,
                kf3: govSteamFV4.kf3,
                khp: govSteamFV4.khp,
                kic: govSteamFV4.kic,
                kip: govSteamFV4.kip,
                kit: govSteamFV4.kit,
                kmp1: govSteamFV4.kmp1,
                kmp2: govSteamFV4.kmp2,
                kpc: govSteamFV4.kpc,
                kpp: govSteamFV4.kpp,
                kpt: govSteamFV4.kpt,
                krc: govSteamFV4.krc,
                ksh: govSteamFV4.ksh,
                lpi: govSteamFV4.lpi,
                lps: govSteamFV4.lps,
                mnef: govSteamFV4.mnef,
                mxef: govSteamFV4.mxef,
                pr1: govSteamFV4.pr1,
                pr2: govSteamFV4.pr2,
                psmn: govSteamFV4.psmn,
                rsmimn: govSteamFV4.rsmimn,
                rsmimx: govSteamFV4.rsmimx,
                rvgmn: govSteamFV4.rvgmn,
                rvgmx: govSteamFV4.rvgmx,
                srmn: govSteamFV4.srmn,
                srmx: govSteamFV4.srmx,
                srsmp: govSteamFV4.srsmp,
                svmn: govSteamFV4.svmn,
                svmx: govSteamFV4.svmx,
                ta: govSteamFV4.ta,
                tam: govSteamFV4.tam,
                tc: govSteamFV4.tc,
                tcm: govSteamFV4.tcm,
                tdc: govSteamFV4.tdc,
                tf1: govSteamFV4.tf1,
                tf2: govSteamFV4.tf2,
                thp: govSteamFV4.thp,
                tmp: govSteamFV4.tmp,
                trh: govSteamFV4.trh,
                tv: govSteamFV4.tv,
                ty: govSteamFV4.ty,
                y: govSteamFV4.y,
                yhpmn: govSteamFV4.yhpmn,
                yhpmx: govSteamFV4.yhpmx,
                ympmn: govSteamFV4.ympmn,
                ympmx: govSteamFV4.ympmx
            });
        });
    }

    updateGovSteamFV4 = (e) => {
        e.preventDefault();
        let govSteamFV4 = {
            govSteamFV4Id: this.state.id,
            cpsmn: this.state.cpsmn,
            cpsmx: this.state.cpsmx,
            crmn: this.state.crmn,
            crmx: this.state.crmx,
            kdc: this.state.kdc,
            kf1: this.state.kf1,
            kf3: this.state.kf3,
            khp: this.state.khp,
            kic: this.state.kic,
            kip: this.state.kip,
            kit: this.state.kit,
            kmp1: this.state.kmp1,
            kmp2: this.state.kmp2,
            kpc: this.state.kpc,
            kpp: this.state.kpp,
            kpt: this.state.kpt,
            krc: this.state.krc,
            ksh: this.state.ksh,
            lpi: this.state.lpi,
            lps: this.state.lps,
            mnef: this.state.mnef,
            mxef: this.state.mxef,
            pr1: this.state.pr1,
            pr2: this.state.pr2,
            psmn: this.state.psmn,
            rsmimn: this.state.rsmimn,
            rsmimx: this.state.rsmimx,
            rvgmn: this.state.rvgmn,
            rvgmx: this.state.rvgmx,
            srmn: this.state.srmn,
            srmx: this.state.srmx,
            srsmp: this.state.srsmp,
            svmn: this.state.svmn,
            svmx: this.state.svmx,
            ta: this.state.ta,
            tam: this.state.tam,
            tc: this.state.tc,
            tcm: this.state.tcm,
            tdc: this.state.tdc,
            tf1: this.state.tf1,
            tf2: this.state.tf2,
            thp: this.state.thp,
            tmp: this.state.tmp,
            trh: this.state.trh,
            tv: this.state.tv,
            ty: this.state.ty,
            y: this.state.y,
            yhpmn: this.state.yhpmn,
            yhpmx: this.state.yhpmx,
            ympmn: this.state.ympmn,
            ympmx: this.state.ympmx
        };
        console.log('govSteamFV4 => ' + JSON.stringify(govSteamFV4));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV4Service.updateGovSteamFV4(govSteamFV4).then( res => {
            this.props.history.push('/govSteamFV4s');
        });
    }

    changecpsmnHandler= (event) => {
        this.setState({cpsmn: event.target.value});
    }
    changecpsmxHandler= (event) => {
        this.setState({cpsmx: event.target.value});
    }
    changecrmnHandler= (event) => {
        this.setState({crmn: event.target.value});
    }
    changecrmxHandler= (event) => {
        this.setState({crmx: event.target.value});
    }
    changekdcHandler= (event) => {
        this.setState({kdc: event.target.value});
    }
    changekf1Handler= (event) => {
        this.setState({kf1: event.target.value});
    }
    changekf3Handler= (event) => {
        this.setState({kf3: event.target.value});
    }
    changekhpHandler= (event) => {
        this.setState({khp: event.target.value});
    }
    changekicHandler= (event) => {
        this.setState({kic: event.target.value});
    }
    changekipHandler= (event) => {
        this.setState({kip: event.target.value});
    }
    changekitHandler= (event) => {
        this.setState({kit: event.target.value});
    }
    changekmp1Handler= (event) => {
        this.setState({kmp1: event.target.value});
    }
    changekmp2Handler= (event) => {
        this.setState({kmp2: event.target.value});
    }
    changekpcHandler= (event) => {
        this.setState({kpc: event.target.value});
    }
    changekppHandler= (event) => {
        this.setState({kpp: event.target.value});
    }
    changekptHandler= (event) => {
        this.setState({kpt: event.target.value});
    }
    changekrcHandler= (event) => {
        this.setState({krc: event.target.value});
    }
    changekshHandler= (event) => {
        this.setState({ksh: event.target.value});
    }
    changelpiHandler= (event) => {
        this.setState({lpi: event.target.value});
    }
    changelpsHandler= (event) => {
        this.setState({lps: event.target.value});
    }
    changemnefHandler= (event) => {
        this.setState({mnef: event.target.value});
    }
    changemxefHandler= (event) => {
        this.setState({mxef: event.target.value});
    }
    changepr1Handler= (event) => {
        this.setState({pr1: event.target.value});
    }
    changepr2Handler= (event) => {
        this.setState({pr2: event.target.value});
    }
    changepsmnHandler= (event) => {
        this.setState({psmn: event.target.value});
    }
    changersmimnHandler= (event) => {
        this.setState({rsmimn: event.target.value});
    }
    changersmimxHandler= (event) => {
        this.setState({rsmimx: event.target.value});
    }
    changervgmnHandler= (event) => {
        this.setState({rvgmn: event.target.value});
    }
    changervgmxHandler= (event) => {
        this.setState({rvgmx: event.target.value});
    }
    changesrmnHandler= (event) => {
        this.setState({srmn: event.target.value});
    }
    changesrmxHandler= (event) => {
        this.setState({srmx: event.target.value});
    }
    changesrsmpHandler= (event) => {
        this.setState({srsmp: event.target.value});
    }
    changesvmnHandler= (event) => {
        this.setState({svmn: event.target.value});
    }
    changesvmxHandler= (event) => {
        this.setState({svmx: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetamHandler= (event) => {
        this.setState({tam: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetcmHandler= (event) => {
        this.setState({tcm: event.target.value});
    }
    changetdcHandler= (event) => {
        this.setState({tdc: event.target.value});
    }
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changethpHandler= (event) => {
        this.setState({thp: event.target.value});
    }
    changetmpHandler= (event) => {
        this.setState({tmp: event.target.value});
    }
    changetrhHandler= (event) => {
        this.setState({trh: event.target.value});
    }
    changetvHandler= (event) => {
        this.setState({tv: event.target.value});
    }
    changetyHandler= (event) => {
        this.setState({ty: event.target.value});
    }
    changeyHandler= (event) => {
        this.setState({y: event.target.value});
    }
    changeyhpmnHandler= (event) => {
        this.setState({yhpmn: event.target.value});
    }
    changeyhpmxHandler= (event) => {
        this.setState({yhpmx: event.target.value});
    }
    changeympmnHandler= (event) => {
        this.setState({ympmn: event.target.value});
    }
    changeympmxHandler= (event) => {
        this.setState({ympmx: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamFV4s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV4</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> cpsmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> cpsmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> crmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> crmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> khp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kic: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kip: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kit: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kmp1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kmp2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> krc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ksh: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lpi: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lps: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mnef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mxef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pr1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pr2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> psmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rsmimn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rsmimx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rvgmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rvgmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> srmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> srmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> srsmp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> svmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> svmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tam: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tcm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tdc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tmp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> trh: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ty: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y: </label>
                                            #formFields( $attribute, 'update')
                                            <label> yhpmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> yhpmx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ympmn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ympmx: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV4}>Save</button>
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

export default UpdateGovSteamFV4Component
