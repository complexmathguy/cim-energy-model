import React, { Component } from 'react'
import ExcSKService from '../services/ExcSKService';

class UpdateExcSKComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdmax: '',
                efdmin: '',
                emax: '',
                emin: '',
                k: '',
                k1: '',
                k2: '',
                kc: '',
                kce: '',
                kd: '',
                kgob: '',
                kp: '',
                kqi: '',
                kqob: '',
                kqp: '',
                nq: '',
                qconoff: '',
                qz: '',
                remote: '',
                sbase: '',
                tc: '',
                te: '',
                ti: '',
                tp: '',
                tr: '',
                uimax: '',
                uimin: '',
                urmax: '',
                urmin: '',
                vtmax: '',
                vtmin: '',
                yp: ''
        }
        this.updateExcSK = this.updateExcSK.bind(this);

        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changeeminHandler = this.changeeminHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekceHandler = this.changekceHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekgobHandler = this.changekgobHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changekqiHandler = this.changekqiHandler.bind(this);
        this.changekqobHandler = this.changekqobHandler.bind(this);
        this.changekqpHandler = this.changekqpHandler.bind(this);
        this.changenqHandler = this.changenqHandler.bind(this);
        this.changeqconoffHandler = this.changeqconoffHandler.bind(this);
        this.changeqzHandler = this.changeqzHandler.bind(this);
        this.changeremoteHandler = this.changeremoteHandler.bind(this);
        this.changesbaseHandler = this.changesbaseHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetiHandler = this.changetiHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
        this.changeuimaxHandler = this.changeuimaxHandler.bind(this);
        this.changeuiminHandler = this.changeuiminHandler.bind(this);
        this.changeurmaxHandler = this.changeurmaxHandler.bind(this);
        this.changeurminHandler = this.changeurminHandler.bind(this);
        this.changevtmaxHandler = this.changevtmaxHandler.bind(this);
        this.changevtminHandler = this.changevtminHandler.bind(this);
        this.changeypHandler = this.changeypHandler.bind(this);
    }

    componentDidMount(){
        ExcSKService.getExcSKById(this.state.id).then( (res) =>{
            let excSK = res.data;
            this.setState({
                efdmax: excSK.efdmax,
                efdmin: excSK.efdmin,
                emax: excSK.emax,
                emin: excSK.emin,
                k: excSK.k,
                k1: excSK.k1,
                k2: excSK.k2,
                kc: excSK.kc,
                kce: excSK.kce,
                kd: excSK.kd,
                kgob: excSK.kgob,
                kp: excSK.kp,
                kqi: excSK.kqi,
                kqob: excSK.kqob,
                kqp: excSK.kqp,
                nq: excSK.nq,
                qconoff: excSK.qconoff,
                qz: excSK.qz,
                remote: excSK.remote,
                sbase: excSK.sbase,
                tc: excSK.tc,
                te: excSK.te,
                ti: excSK.ti,
                tp: excSK.tp,
                tr: excSK.tr,
                uimax: excSK.uimax,
                uimin: excSK.uimin,
                urmax: excSK.urmax,
                urmin: excSK.urmin,
                vtmax: excSK.vtmax,
                vtmin: excSK.vtmin,
                yp: excSK.yp
            });
        });
    }

    updateExcSK = (e) => {
        e.preventDefault();
        let excSK = {
            excSKId: this.state.id,
            efdmax: this.state.efdmax,
            efdmin: this.state.efdmin,
            emax: this.state.emax,
            emin: this.state.emin,
            k: this.state.k,
            k1: this.state.k1,
            k2: this.state.k2,
            kc: this.state.kc,
            kce: this.state.kce,
            kd: this.state.kd,
            kgob: this.state.kgob,
            kp: this.state.kp,
            kqi: this.state.kqi,
            kqob: this.state.kqob,
            kqp: this.state.kqp,
            nq: this.state.nq,
            qconoff: this.state.qconoff,
            qz: this.state.qz,
            remote: this.state.remote,
            sbase: this.state.sbase,
            tc: this.state.tc,
            te: this.state.te,
            ti: this.state.ti,
            tp: this.state.tp,
            tr: this.state.tr,
            uimax: this.state.uimax,
            uimin: this.state.uimin,
            urmax: this.state.urmax,
            urmin: this.state.urmin,
            vtmax: this.state.vtmax,
            vtmin: this.state.vtmin,
            yp: this.state.yp
        };
        console.log('excSK => ' + JSON.stringify(excSK));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSKService.updateExcSK(excSK).then( res => {
            this.props.history.push('/excSKs');
        });
    }

    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changeeminHandler= (event) => {
        this.setState({emin: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekceHandler= (event) => {
        this.setState({kce: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekgobHandler= (event) => {
        this.setState({kgob: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changekqiHandler= (event) => {
        this.setState({kqi: event.target.value});
    }
    changekqobHandler= (event) => {
        this.setState({kqob: event.target.value});
    }
    changekqpHandler= (event) => {
        this.setState({kqp: event.target.value});
    }
    changenqHandler= (event) => {
        this.setState({nq: event.target.value});
    }
    changeqconoffHandler= (event) => {
        this.setState({qconoff: event.target.value});
    }
    changeqzHandler= (event) => {
        this.setState({qz: event.target.value});
    }
    changeremoteHandler= (event) => {
        this.setState({remote: event.target.value});
    }
    changesbaseHandler= (event) => {
        this.setState({sbase: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetiHandler= (event) => {
        this.setState({ti: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }
    changeuimaxHandler= (event) => {
        this.setState({uimax: event.target.value});
    }
    changeuiminHandler= (event) => {
        this.setState({uimin: event.target.value});
    }
    changeurmaxHandler= (event) => {
        this.setState({urmax: event.target.value});
    }
    changeurminHandler= (event) => {
        this.setState({urmin: event.target.value});
    }
    changevtmaxHandler= (event) => {
        this.setState({vtmax: event.target.value});
    }
    changevtminHandler= (event) => {
        this.setState({vtmin: event.target.value});
    }
    changeypHandler= (event) => {
        this.setState({yp: event.target.value});
    }

    cancel(){
        this.props.history.push('/excSKs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSK</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kce: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kgob: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kqi: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kqob: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kqp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> nq: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qconoff: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qz: </label>
                                            #formFields( $attribute, 'update')
                                            <label> remote: </label>
                                            #formFields( $attribute, 'update')
                                            <label> sbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uimin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> urmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> urmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vtmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vtmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> yp: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSK}>Save</button>
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

export default UpdateExcSKComponent
