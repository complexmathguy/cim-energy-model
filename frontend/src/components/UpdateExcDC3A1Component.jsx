import React, { Component } from 'react'
import ExcDC3A1Service from '../services/ExcDC3A1Service';

class UpdateExcDC3A1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                exclim: '',
                ka: '',
                ke: '',
                kf: '',
                ki: '',
                kp: '',
                ta: '',
                te: '',
                tf: '',
                vb1max: '',
                vblim: '',
                vbmax: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcDC3A1 = this.updateExcDC3A1.bind(this);

        this.changeexclimHandler = this.changeexclimHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevb1maxHandler = this.changevb1maxHandler.bind(this);
        this.changevblimHandler = this.changevblimHandler.bind(this);
        this.changevbmaxHandler = this.changevbmaxHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcDC3A1Service.getExcDC3A1ById(this.state.id).then( (res) =>{
            let excDC3A1 = res.data;
            this.setState({
                exclim: excDC3A1.exclim,
                ka: excDC3A1.ka,
                ke: excDC3A1.ke,
                kf: excDC3A1.kf,
                ki: excDC3A1.ki,
                kp: excDC3A1.kp,
                ta: excDC3A1.ta,
                te: excDC3A1.te,
                tf: excDC3A1.tf,
                vb1max: excDC3A1.vb1max,
                vblim: excDC3A1.vblim,
                vbmax: excDC3A1.vbmax,
                vrmax: excDC3A1.vrmax,
                vrmin: excDC3A1.vrmin
            });
        });
    }

    updateExcDC3A1 = (e) => {
        e.preventDefault();
        let excDC3A1 = {
            excDC3A1Id: this.state.id,
            exclim: this.state.exclim,
            ka: this.state.ka,
            ke: this.state.ke,
            kf: this.state.kf,
            ki: this.state.ki,
            kp: this.state.kp,
            ta: this.state.ta,
            te: this.state.te,
            tf: this.state.tf,
            vb1max: this.state.vb1max,
            vblim: this.state.vblim,
            vbmax: this.state.vbmax,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excDC3A1 => ' + JSON.stringify(excDC3A1));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC3A1Service.updateExcDC3A1(excDC3A1).then( res => {
            this.props.history.push('/excDC3A1s');
        });
    }

    changeexclimHandler= (event) => {
        this.setState({exclim: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
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
    changevb1maxHandler= (event) => {
        this.setState({vb1max: event.target.value});
    }
    changevblimHandler= (event) => {
        this.setState({vblim: event.target.value});
    }
    changevbmaxHandler= (event) => {
        this.setState({vbmax: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excDC3A1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC3A1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> exclim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
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
                                            <label> vb1max: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vblim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vbmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC3A1}>Save</button>
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

export default UpdateExcDC3A1Component
