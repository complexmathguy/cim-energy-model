import React, { Component } from 'react'
import ExcAC1AService from '../services/ExcAC1AService';

class UpdateExcAC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                hvlvgates: '',
                ka: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                kf1: '',
                kf2: '',
                ks: '',
                seve1: '',
                seve2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                vamax: '',
                vamin: '',
                ve1: '',
                ve2: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcAC1A = this.updateExcAC1A.bind(this);

        this.changehvlvgatesHandler = this.changehvlvgatesHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekf1Handler = this.changekf1Handler.bind(this);
        this.changekf2Handler = this.changekf2Handler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcAC1AService.getExcAC1AById(this.state.id).then( (res) =>{
            let excAC1A = res.data;
            this.setState({
                hvlvgates: excAC1A.hvlvgates,
                ka: excAC1A.ka,
                kc: excAC1A.kc,
                kd: excAC1A.kd,
                ke: excAC1A.ke,
                kf: excAC1A.kf,
                kf1: excAC1A.kf1,
                kf2: excAC1A.kf2,
                ks: excAC1A.ks,
                seve1: excAC1A.seve1,
                seve2: excAC1A.seve2,
                ta: excAC1A.ta,
                tb: excAC1A.tb,
                tc: excAC1A.tc,
                te: excAC1A.te,
                tf: excAC1A.tf,
                vamax: excAC1A.vamax,
                vamin: excAC1A.vamin,
                ve1: excAC1A.ve1,
                ve2: excAC1A.ve2,
                vrmax: excAC1A.vrmax,
                vrmin: excAC1A.vrmin
            });
        });
    }

    updateExcAC1A = (e) => {
        e.preventDefault();
        let excAC1A = {
            excAC1AId: this.state.id,
            hvlvgates: this.state.hvlvgates,
            ka: this.state.ka,
            kc: this.state.kc,
            kd: this.state.kd,
            ke: this.state.ke,
            kf: this.state.kf,
            kf1: this.state.kf1,
            kf2: this.state.kf2,
            ks: this.state.ks,
            seve1: this.state.seve1,
            seve2: this.state.seve2,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            te: this.state.te,
            tf: this.state.tf,
            vamax: this.state.vamax,
            vamin: this.state.vamin,
            ve1: this.state.ve1,
            ve2: this.state.ve2,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excAC1A => ' + JSON.stringify(excAC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcAC1AService.updateExcAC1A(excAC1A).then( res => {
            this.props.history.push('/excAC1As');
        });
    }

    changehvlvgatesHandler= (event) => {
        this.setState({hvlvgates: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
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
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekf1Handler= (event) => {
        this.setState({kf1: event.target.value});
    }
    changekf2Handler= (event) => {
        this.setState({kf2: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changeseve1Handler= (event) => {
        this.setState({seve1: event.target.value});
    }
    changeseve2Handler= (event) => {
        this.setState({seve2: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcAC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> hvlvgates: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcAC1A}>Save</button>
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

export default UpdateExcAC1AComponent
