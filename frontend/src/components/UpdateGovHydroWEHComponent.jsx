import React, { Component } from 'react'
import GovHydroWEHService from '../services/GovHydroWEHService';

class UpdateGovHydroWEHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                db: '',
                dicn: '',
                dpv: '',
                dturb: '',
                feedbackSignal: '',
                fl1: '',
                fl2: '',
                fl3: '',
                fl4: '',
                fl5: '',
                fp1: '',
                fp10: '',
                fp2: '',
                fp3: '',
                fp4: '',
                fp5: '',
                fp6: '',
                fp7: '',
                fp8: '',
                fp9: '',
                gmax: '',
                gmin: '',
                gtmxcl: '',
                gtmxop: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                kd: '',
                ki: '',
                kp: '',
                mwbase: '',
                pmss1: '',
                pmss10: '',
                pmss2: '',
                pmss3: '',
                pmss4: '',
                pmss5: '',
                pmss6: '',
                pmss7: '',
                pmss8: '',
                pmss9: '',
                rpg: '',
                rpp: '',
                td: '',
                tdv: '',
                tg: '',
                tp: '',
                tpe: '',
                tw: ''
        }
        this.updateGovHydroWEH = this.updateGovHydroWEH.bind(this);

        this.changedbHandler = this.changedbHandler.bind(this);
        this.changedicnHandler = this.changedicnHandler.bind(this);
        this.changedpvHandler = this.changedpvHandler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changefeedbackSignalHandler = this.changefeedbackSignalHandler.bind(this);
        this.changefl1Handler = this.changefl1Handler.bind(this);
        this.changefl2Handler = this.changefl2Handler.bind(this);
        this.changefl3Handler = this.changefl3Handler.bind(this);
        this.changefl4Handler = this.changefl4Handler.bind(this);
        this.changefl5Handler = this.changefl5Handler.bind(this);
        this.changefp1Handler = this.changefp1Handler.bind(this);
        this.changefp10Handler = this.changefp10Handler.bind(this);
        this.changefp2Handler = this.changefp2Handler.bind(this);
        this.changefp3Handler = this.changefp3Handler.bind(this);
        this.changefp4Handler = this.changefp4Handler.bind(this);
        this.changefp5Handler = this.changefp5Handler.bind(this);
        this.changefp6Handler = this.changefp6Handler.bind(this);
        this.changefp7Handler = this.changefp7Handler.bind(this);
        this.changefp8Handler = this.changefp8Handler.bind(this);
        this.changefp9Handler = this.changefp9Handler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changegtmxclHandler = this.changegtmxclHandler.bind(this);
        this.changegtmxopHandler = this.changegtmxopHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmss1Handler = this.changepmss1Handler.bind(this);
        this.changepmss10Handler = this.changepmss10Handler.bind(this);
        this.changepmss2Handler = this.changepmss2Handler.bind(this);
        this.changepmss3Handler = this.changepmss3Handler.bind(this);
        this.changepmss4Handler = this.changepmss4Handler.bind(this);
        this.changepmss5Handler = this.changepmss5Handler.bind(this);
        this.changepmss6Handler = this.changepmss6Handler.bind(this);
        this.changepmss7Handler = this.changepmss7Handler.bind(this);
        this.changepmss8Handler = this.changepmss8Handler.bind(this);
        this.changepmss9Handler = this.changepmss9Handler.bind(this);
        this.changerpgHandler = this.changerpgHandler.bind(this);
        this.changerppHandler = this.changerppHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetdvHandler = this.changetdvHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetpeHandler = this.changetpeHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
    }

    componentDidMount(){
        GovHydroWEHService.getGovHydroWEHById(this.state.id).then( (res) =>{
            let govHydroWEH = res.data;
            this.setState({
                db: govHydroWEH.db,
                dicn: govHydroWEH.dicn,
                dpv: govHydroWEH.dpv,
                dturb: govHydroWEH.dturb,
                feedbackSignal: govHydroWEH.feedbackSignal,
                fl1: govHydroWEH.fl1,
                fl2: govHydroWEH.fl2,
                fl3: govHydroWEH.fl3,
                fl4: govHydroWEH.fl4,
                fl5: govHydroWEH.fl5,
                fp1: govHydroWEH.fp1,
                fp10: govHydroWEH.fp10,
                fp2: govHydroWEH.fp2,
                fp3: govHydroWEH.fp3,
                fp4: govHydroWEH.fp4,
                fp5: govHydroWEH.fp5,
                fp6: govHydroWEH.fp6,
                fp7: govHydroWEH.fp7,
                fp8: govHydroWEH.fp8,
                fp9: govHydroWEH.fp9,
                gmax: govHydroWEH.gmax,
                gmin: govHydroWEH.gmin,
                gtmxcl: govHydroWEH.gtmxcl,
                gtmxop: govHydroWEH.gtmxop,
                gv1: govHydroWEH.gv1,
                gv2: govHydroWEH.gv2,
                gv3: govHydroWEH.gv3,
                gv4: govHydroWEH.gv4,
                gv5: govHydroWEH.gv5,
                kd: govHydroWEH.kd,
                ki: govHydroWEH.ki,
                kp: govHydroWEH.kp,
                mwbase: govHydroWEH.mwbase,
                pmss1: govHydroWEH.pmss1,
                pmss10: govHydroWEH.pmss10,
                pmss2: govHydroWEH.pmss2,
                pmss3: govHydroWEH.pmss3,
                pmss4: govHydroWEH.pmss4,
                pmss5: govHydroWEH.pmss5,
                pmss6: govHydroWEH.pmss6,
                pmss7: govHydroWEH.pmss7,
                pmss8: govHydroWEH.pmss8,
                pmss9: govHydroWEH.pmss9,
                rpg: govHydroWEH.rpg,
                rpp: govHydroWEH.rpp,
                td: govHydroWEH.td,
                tdv: govHydroWEH.tdv,
                tg: govHydroWEH.tg,
                tp: govHydroWEH.tp,
                tpe: govHydroWEH.tpe,
                tw: govHydroWEH.tw
            });
        });
    }

    updateGovHydroWEH = (e) => {
        e.preventDefault();
        let govHydroWEH = {
            govHydroWEHId: this.state.id,
            db: this.state.db,
            dicn: this.state.dicn,
            dpv: this.state.dpv,
            dturb: this.state.dturb,
            feedbackSignal: this.state.feedbackSignal,
            fl1: this.state.fl1,
            fl2: this.state.fl2,
            fl3: this.state.fl3,
            fl4: this.state.fl4,
            fl5: this.state.fl5,
            fp1: this.state.fp1,
            fp10: this.state.fp10,
            fp2: this.state.fp2,
            fp3: this.state.fp3,
            fp4: this.state.fp4,
            fp5: this.state.fp5,
            fp6: this.state.fp6,
            fp7: this.state.fp7,
            fp8: this.state.fp8,
            fp9: this.state.fp9,
            gmax: this.state.gmax,
            gmin: this.state.gmin,
            gtmxcl: this.state.gtmxcl,
            gtmxop: this.state.gtmxop,
            gv1: this.state.gv1,
            gv2: this.state.gv2,
            gv3: this.state.gv3,
            gv4: this.state.gv4,
            gv5: this.state.gv5,
            kd: this.state.kd,
            ki: this.state.ki,
            kp: this.state.kp,
            mwbase: this.state.mwbase,
            pmss1: this.state.pmss1,
            pmss10: this.state.pmss10,
            pmss2: this.state.pmss2,
            pmss3: this.state.pmss3,
            pmss4: this.state.pmss4,
            pmss5: this.state.pmss5,
            pmss6: this.state.pmss6,
            pmss7: this.state.pmss7,
            pmss8: this.state.pmss8,
            pmss9: this.state.pmss9,
            rpg: this.state.rpg,
            rpp: this.state.rpp,
            td: this.state.td,
            tdv: this.state.tdv,
            tg: this.state.tg,
            tp: this.state.tp,
            tpe: this.state.tpe,
            tw: this.state.tw
        };
        console.log('govHydroWEH => ' + JSON.stringify(govHydroWEH));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroWEHService.updateGovHydroWEH(govHydroWEH).then( res => {
            this.props.history.push('/govHydroWEHs');
        });
    }

    changedbHandler= (event) => {
        this.setState({db: event.target.value});
    }
    changedicnHandler= (event) => {
        this.setState({dicn: event.target.value});
    }
    changedpvHandler= (event) => {
        this.setState({dpv: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
    }
    changefeedbackSignalHandler= (event) => {
        this.setState({feedbackSignal: event.target.value});
    }
    changefl1Handler= (event) => {
        this.setState({fl1: event.target.value});
    }
    changefl2Handler= (event) => {
        this.setState({fl2: event.target.value});
    }
    changefl3Handler= (event) => {
        this.setState({fl3: event.target.value});
    }
    changefl4Handler= (event) => {
        this.setState({fl4: event.target.value});
    }
    changefl5Handler= (event) => {
        this.setState({fl5: event.target.value});
    }
    changefp1Handler= (event) => {
        this.setState({fp1: event.target.value});
    }
    changefp10Handler= (event) => {
        this.setState({fp10: event.target.value});
    }
    changefp2Handler= (event) => {
        this.setState({fp2: event.target.value});
    }
    changefp3Handler= (event) => {
        this.setState({fp3: event.target.value});
    }
    changefp4Handler= (event) => {
        this.setState({fp4: event.target.value});
    }
    changefp5Handler= (event) => {
        this.setState({fp5: event.target.value});
    }
    changefp6Handler= (event) => {
        this.setState({fp6: event.target.value});
    }
    changefp7Handler= (event) => {
        this.setState({fp7: event.target.value});
    }
    changefp8Handler= (event) => {
        this.setState({fp8: event.target.value});
    }
    changefp9Handler= (event) => {
        this.setState({fp9: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
    }
    changegtmxclHandler= (event) => {
        this.setState({gtmxcl: event.target.value});
    }
    changegtmxopHandler= (event) => {
        this.setState({gtmxop: event.target.value});
    }
    changegv1Handler= (event) => {
        this.setState({gv1: event.target.value});
    }
    changegv2Handler= (event) => {
        this.setState({gv2: event.target.value});
    }
    changegv3Handler= (event) => {
        this.setState({gv3: event.target.value});
    }
    changegv4Handler= (event) => {
        this.setState({gv4: event.target.value});
    }
    changegv5Handler= (event) => {
        this.setState({gv5: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepmss1Handler= (event) => {
        this.setState({pmss1: event.target.value});
    }
    changepmss10Handler= (event) => {
        this.setState({pmss10: event.target.value});
    }
    changepmss2Handler= (event) => {
        this.setState({pmss2: event.target.value});
    }
    changepmss3Handler= (event) => {
        this.setState({pmss3: event.target.value});
    }
    changepmss4Handler= (event) => {
        this.setState({pmss4: event.target.value});
    }
    changepmss5Handler= (event) => {
        this.setState({pmss5: event.target.value});
    }
    changepmss6Handler= (event) => {
        this.setState({pmss6: event.target.value});
    }
    changepmss7Handler= (event) => {
        this.setState({pmss7: event.target.value});
    }
    changepmss8Handler= (event) => {
        this.setState({pmss8: event.target.value});
    }
    changepmss9Handler= (event) => {
        this.setState({pmss9: event.target.value});
    }
    changerpgHandler= (event) => {
        this.setState({rpg: event.target.value});
    }
    changerppHandler= (event) => {
        this.setState({rpp: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetdvHandler= (event) => {
        this.setState({tdv: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetpeHandler= (event) => {
        this.setState({tpe: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroWEHs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroWEH</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> db: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dicn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dpv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> feedbackSignal: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fl1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fl2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fl3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fl4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fl5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp10: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp8: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fp9: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gtmxcl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gtmxop: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss10: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss8: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmss9: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rpg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tdv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpe: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroWEH}>Save</button>
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

export default UpdateGovHydroWEHComponent
