import React, { Component } from 'react'
import ExcIEEEST2AService from '../services/ExcIEEEST2AService';

class UpdateExcIEEEST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdmax: '',
                ka: '',
                kc: '',
                ke: '',
                kf: '',
                ki: '',
                kp: '',
                ta: '',
                te: '',
                tf: '',
                uelin: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcIEEEST2A = this.updateExcIEEEST2A.bind(this);

        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEST2AService.getExcIEEEST2AById(this.state.id).then( (res) =>{
            let excIEEEST2A = res.data;
            this.setState({
                efdmax: excIEEEST2A.efdmax,
                ka: excIEEEST2A.ka,
                kc: excIEEEST2A.kc,
                ke: excIEEEST2A.ke,
                kf: excIEEEST2A.kf,
                ki: excIEEEST2A.ki,
                kp: excIEEEST2A.kp,
                ta: excIEEEST2A.ta,
                te: excIEEEST2A.te,
                tf: excIEEEST2A.tf,
                uelin: excIEEEST2A.uelin,
                vrmax: excIEEEST2A.vrmax,
                vrmin: excIEEEST2A.vrmin
            });
        });
    }

    updateExcIEEEST2A = (e) => {
        e.preventDefault();
        let excIEEEST2A = {
            excIEEEST2AId: this.state.id,
            efdmax: this.state.efdmax,
            ka: this.state.ka,
            kc: this.state.kc,
            ke: this.state.ke,
            kf: this.state.kf,
            ki: this.state.ki,
            kp: this.state.kp,
            ta: this.state.ta,
            te: this.state.te,
            tf: this.state.tf,
            uelin: this.state.uelin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excIEEEST2A => ' + JSON.stringify(excIEEEST2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEST2AService.updateExcIEEEST2A(excIEEEST2A).then( res => {
            this.props.history.push('/excIEEEST2As');
        });
    }

    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changeuelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEST2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEST2A}>Save</button>
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

export default UpdateExcIEEEST2AComponent
