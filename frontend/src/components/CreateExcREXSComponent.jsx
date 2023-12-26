import React, { Component } from 'react'
import ExcREXSService from '../services/ExcREXSService';

class CreateExcREXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                e1: '',
                e2: '',
                fbf: '',
                flimf: '',
                kc: '',
                kd: '',
                ke: '',
                kefd: '',
                kf: '',
                kh: '',
                kii: '',
                kip: '',
                ks: '',
                kvi: '',
                kvp: '',
                kvphz: '',
                nvphz: '',
                se1: '',
                se2: '',
                ta: '',
                tb1: '',
                tb2: '',
                tc1: '',
                tc2: '',
                te: '',
                tf: '',
                tf1: '',
                tf2: '',
                tp: '',
                vcmax: '',
                vfmax: '',
                vfmin: '',
                vimax: '',
                vrmax: '',
                vrmin: '',
                xc: ''
        }
        this.changee1Handler = this.changee1Handler.bind(this);
        this.changee2Handler = this.changee2Handler.bind(this);
        this.changefbfHandler = this.changefbfHandler.bind(this);
        this.changeflimfHandler = this.changeflimfHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekefdHandler = this.changekefdHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekhHandler = this.changekhHandler.bind(this);
        this.changekiiHandler = this.changekiiHandler.bind(this);
        this.changekipHandler = this.changekipHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changekviHandler = this.changekviHandler.bind(this);
        this.changekvpHandler = this.changekvpHandler.bind(this);
        this.changekvphzHandler = this.changekvphzHandler.bind(this);
        this.changenvphzHandler = this.changenvphzHandler.bind(this);
        this.changese1Handler = this.changese1Handler.bind(this);
        this.changese2Handler = this.changese2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetb1Handler = this.changetb1Handler.bind(this);
        this.changetb2Handler = this.changetb2Handler.bind(this);
        this.changetc1Handler = this.changetc1Handler.bind(this);
        this.changetc2Handler = this.changetc2Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changetf2Handler = this.changetf2Handler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changevcmaxHandler = this.changevcmaxHandler.bind(this);
        this.changevfmaxHandler = this.changevfmaxHandler.bind(this);
        this.changevfminHandler = this.changevfminHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexcHandler = this.changexcHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcREXSService.getExcREXSById(this.state.id).then( (res) =>{
                let excREXS = res.data;
                this.setState({
                    e1: excREXS.e1,
                    e2: excREXS.e2,
                    fbf: excREXS.fbf,
                    flimf: excREXS.flimf,
                    kc: excREXS.kc,
                    kd: excREXS.kd,
                    ke: excREXS.ke,
                    kefd: excREXS.kefd,
                    kf: excREXS.kf,
                    kh: excREXS.kh,
                    kii: excREXS.kii,
                    kip: excREXS.kip,
                    ks: excREXS.ks,
                    kvi: excREXS.kvi,
                    kvp: excREXS.kvp,
                    kvphz: excREXS.kvphz,
                    nvphz: excREXS.nvphz,
                    se1: excREXS.se1,
                    se2: excREXS.se2,
                    ta: excREXS.ta,
                    tb1: excREXS.tb1,
                    tb2: excREXS.tb2,
                    tc1: excREXS.tc1,
                    tc2: excREXS.tc2,
                    te: excREXS.te,
                    tf: excREXS.tf,
                    tf1: excREXS.tf1,
                    tf2: excREXS.tf2,
                    tp: excREXS.tp,
                    vcmax: excREXS.vcmax,
                    vfmax: excREXS.vfmax,
                    vfmin: excREXS.vfmin,
                    vimax: excREXS.vimax,
                    vrmax: excREXS.vrmax,
                    vrmin: excREXS.vrmin,
                    xc: excREXS.xc
                });
            });
        }        
    }
    saveOrUpdateExcREXS = (e) => {
        e.preventDefault();
        let excREXS = {
                excREXSId: this.state.id,
                e1: this.state.e1,
                e2: this.state.e2,
                fbf: this.state.fbf,
                flimf: this.state.flimf,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kefd: this.state.kefd,
                kf: this.state.kf,
                kh: this.state.kh,
                kii: this.state.kii,
                kip: this.state.kip,
                ks: this.state.ks,
                kvi: this.state.kvi,
                kvp: this.state.kvp,
                kvphz: this.state.kvphz,
                nvphz: this.state.nvphz,
                se1: this.state.se1,
                se2: this.state.se2,
                ta: this.state.ta,
                tb1: this.state.tb1,
                tb2: this.state.tb2,
                tc1: this.state.tc1,
                tc2: this.state.tc2,
                te: this.state.te,
                tf: this.state.tf,
                tf1: this.state.tf1,
                tf2: this.state.tf2,
                tp: this.state.tp,
                vcmax: this.state.vcmax,
                vfmax: this.state.vfmax,
                vfmin: this.state.vfmin,
                vimax: this.state.vimax,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xc: this.state.xc
            };
        console.log('excREXS => ' + JSON.stringify(excREXS));

        // step 5
        if(this.state.id === '_add'){
            excREXS.excREXSId=''
            ExcREXSService.createExcREXS(excREXS).then(res =>{
                this.props.history.push('/excREXSs');
            });
        }else{
            ExcREXSService.updateExcREXS(excREXS).then( res => {
                this.props.history.push('/excREXSs');
            });
        }
    }
    
    changee1Handler= (event) => {
        this.setState({e1: event.target.value});
    }
    changee2Handler= (event) => {
        this.setState({e2: event.target.value});
    }
    changefbfHandler= (event) => {
        this.setState({fbf: event.target.value});
    }
    changeflimfHandler= (event) => {
        this.setState({flimf: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekefdHandler= (event) => {
        this.setState({kefd: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changekiiHandler= (event) => {
        this.setState({kii: event.target.value});
    }
    changekipHandler= (event) => {
        this.setState({kip: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changekviHandler= (event) => {
        this.setState({kvi: event.target.value});
    }
    changekvpHandler= (event) => {
        this.setState({kvp: event.target.value});
    }
    changekvphzHandler= (event) => {
        this.setState({kvphz: event.target.value});
    }
    changenvphzHandler= (event) => {
        this.setState({nvphz: event.target.value});
    }
    changese1Handler= (event) => {
        this.setState({se1: event.target.value});
    }
    changese2Handler= (event) => {
        this.setState({se2: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetb1Handler= (event) => {
        this.setState({tb1: event.target.value});
    }
    changetb2Handler= (event) => {
        this.setState({tb2: event.target.value});
    }
    changetc1Handler= (event) => {
        this.setState({tc1: event.target.value});
    }
    changetc2Handler= (event) => {
        this.setState({tc2: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changetf2Handler= (event) => {
        this.setState({tf2: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changevcmaxHandler= (event) => {
        this.setState({vcmax: event.target.value});
    }
    changevfmaxHandler= (event) => {
        this.setState({vfmax: event.target.value});
    }
    changevfminHandler= (event) => {
        this.setState({vfmin: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changexcHandler= (event) => {
        this.setState({xc: event.target.value});
    }

    cancel(){
        this.props.history.push('/excREXSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcREXS</h3>
        }else{
            return <h3 className="text-center">Update ExcREXS</h3>
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
                                            <label> e1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> e2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fbf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> flimf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kefd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kii: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kvi: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kvp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kvphz: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nvphz: </label>
                                            #formFields( $attribute, 'create')
                                            <label> se1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> se2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vcmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xc: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcREXS}>Save</button>
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

export default CreateExcREXSComponent
