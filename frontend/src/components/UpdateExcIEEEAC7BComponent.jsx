import React, { Component } from 'react'
import ExcIEEEAC7BService from '../services/ExcIEEEAC7BService';

class UpdateExcIEEEAC7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kc: '',
                kd: '',
                kdr: '',
                ke: '',
                kf1: '',
                kf2: '',
                kf3: '',
                kia: '',
                kir: '',
                kl: '',
                kp: '',
                kpa: '',
                kpr: '',
                seve1: '',
                seve2: '',
                tdr: '',
                te: '',
                tf: '',
                vamax: '',
                vamin: '',
                ve1: '',
                ve2: '',
                vemin: '',
                vfemax: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcIEEEAC7B = this.updateExcIEEEAC7B.bind(this);

        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekdrHandler = this.changekdrHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekf1Handler = this.changekf1Handler.bind(this);
        this.changekf2Handler = this.changekf2Handler.bind(this);
        this.changekf3Handler = this.changekf3Handler.bind(this);
        this.changekiaHandler = this.changekiaHandler.bind(this);
        this.changekirHandler = this.changekirHandler.bind(this);
        this.changeklHandler = this.changeklHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changekpaHandler = this.changekpaHandler.bind(this);
        this.changekprHandler = this.changekprHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetdrHandler = this.changetdrHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changeveminHandler = this.changeveminHandler.bind(this);
        this.changevfemaxHandler = this.changevfemaxHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEAC7BService.getExcIEEEAC7BById(this.state.id).then( (res) =>{
            let excIEEEAC7B = res.data;
            this.setState({
                kc: excIEEEAC7B.kc,
                kd: excIEEEAC7B.kd,
                kdr: excIEEEAC7B.kdr,
                ke: excIEEEAC7B.ke,
                kf1: excIEEEAC7B.kf1,
                kf2: excIEEEAC7B.kf2,
                kf3: excIEEEAC7B.kf3,
                kia: excIEEEAC7B.kia,
                kir: excIEEEAC7B.kir,
                kl: excIEEEAC7B.kl,
                kp: excIEEEAC7B.kp,
                kpa: excIEEEAC7B.kpa,
                kpr: excIEEEAC7B.kpr,
                seve1: excIEEEAC7B.seve1,
                seve2: excIEEEAC7B.seve2,
                tdr: excIEEEAC7B.tdr,
                te: excIEEEAC7B.te,
                tf: excIEEEAC7B.tf,
                vamax: excIEEEAC7B.vamax,
                vamin: excIEEEAC7B.vamin,
                ve1: excIEEEAC7B.ve1,
                ve2: excIEEEAC7B.ve2,
                vemin: excIEEEAC7B.vemin,
                vfemax: excIEEEAC7B.vfemax,
                vrmax: excIEEEAC7B.vrmax,
                vrmin: excIEEEAC7B.vrmin
            });
        });
    }

    updateExcIEEEAC7B = (e) => {
        e.preventDefault();
        let excIEEEAC7B = {
            excIEEEAC7BId: this.state.id,
            kc: this.state.kc,
            kd: this.state.kd,
            kdr: this.state.kdr,
            ke: this.state.ke,
            kf1: this.state.kf1,
            kf2: this.state.kf2,
            kf3: this.state.kf3,
            kia: this.state.kia,
            kir: this.state.kir,
            kl: this.state.kl,
            kp: this.state.kp,
            kpa: this.state.kpa,
            kpr: this.state.kpr,
            seve1: this.state.seve1,
            seve2: this.state.seve2,
            tdr: this.state.tdr,
            te: this.state.te,
            tf: this.state.tf,
            vamax: this.state.vamax,
            vamin: this.state.vamin,
            ve1: this.state.ve1,
            ve2: this.state.ve2,
            vemin: this.state.vemin,
            vfemax: this.state.vfemax,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excIEEEAC7B => ' + JSON.stringify(excIEEEAC7B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC7BService.updateExcIEEEAC7B(excIEEEAC7B).then( res => {
            this.props.history.push('/excIEEEAC7Bs');
        });
    }

    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekdrHandler= (event) => {
        this.setState({kdr: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekf1Handler= (event) => {
        this.setState({kf1: event.target.value});
    }
    changekf2Handler= (event) => {
        this.setState({kf2: event.target.value});
    }
    changekf3Handler= (event) => {
        this.setState({kf3: event.target.value});
    }
    changekiaHandler= (event) => {
        this.setState({kia: event.target.value});
    }
    changekirHandler= (event) => {
        this.setState({kir: event.target.value});
    }
    changeklHandler= (event) => {
        this.setState({kl: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changekpaHandler= (event) => {
        this.setState({kpa: event.target.value});
    }
    changekprHandler= (event) => {
        this.setState({kpr: event.target.value});
    }
    changeseve1Handler= (event) => {
        this.setState({seve1: event.target.value});
    }
    changeseve2Handler= (event) => {
        this.setState({seve2: event.target.value});
    }
    changetdrHandler= (event) => {
        this.setState({tdr: event.target.value});
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
    changeveminHandler= (event) => {
        this.setState({vemin: event.target.value});
    }
    changevfemaxHandler= (event) => {
        this.setState({vfemax: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEAC7Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC7B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kdr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kia: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kir: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpa: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tdr: </label>
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
                                            <label> vemin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vfemax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC7B}>Save</button>
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

export default UpdateExcIEEEAC7BComponent
