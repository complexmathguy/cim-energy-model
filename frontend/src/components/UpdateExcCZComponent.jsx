import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService';

class UpdateExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdmax: '',
                efdmin: '',
                ka: '',
                ke: '',
                kp: '',
                ta: '',
                tc: '',
                te: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcCZ = this.updateExcCZ.bind(this);

        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcCZService.getExcCZById(this.state.id).then( (res) =>{
            let excCZ = res.data;
            this.setState({
                efdmax: excCZ.efdmax,
                efdmin: excCZ.efdmin,
                ka: excCZ.ka,
                ke: excCZ.ke,
                kp: excCZ.kp,
                ta: excCZ.ta,
                tc: excCZ.tc,
                te: excCZ.te,
                vrmax: excCZ.vrmax,
                vrmin: excCZ.vrmin
            });
        });
    }

    updateExcCZ = (e) => {
        e.preventDefault();
        let excCZ = {
            excCZId: this.state.id,
            efdmax: this.state.efdmax,
            efdmin: this.state.efdmin,
            ka: this.state.ka,
            ke: this.state.ke,
            kp: this.state.kp,
            ta: this.state.ta,
            tc: this.state.tc,
            te: this.state.te,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excCZ => ' + JSON.stringify(excCZ));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcCZService.updateExcCZ(excCZ).then( res => {
            this.props.history.push('/excCZs');
        });
    }

    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excCZs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcCZ</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcCZ}>Save</button>
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

export default UpdateExcCZComponent
