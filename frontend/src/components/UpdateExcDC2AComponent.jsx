import React, { Component } from 'react'
import ExcDC2AService from '../services/ExcDC2AService';

class UpdateExcDC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efd1: '',
                efd2: '',
                exclim: '',
                ka: '',
                ke: '',
                kf: '',
                ks: '',
                seefd1: '',
                seefd2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                tf1: '',
                vrmax: '',
                vrmin: '',
                vtlim: ''
        }
        this.updateExcDC2A = this.updateExcDC2A.bind(this);

        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeexclimHandler = this.changeexclimHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changeseefd1Handler = this.changeseefd1Handler.bind(this);
        this.changeseefd2Handler = this.changeseefd2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetf1Handler = this.changetf1Handler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changevtlimHandler = this.changevtlimHandler.bind(this);
    }

    componentDidMount(){
        ExcDC2AService.getExcDC2AById(this.state.id).then( (res) =>{
            let excDC2A = res.data;
            this.setState({
                efd1: excDC2A.efd1,
                efd2: excDC2A.efd2,
                exclim: excDC2A.exclim,
                ka: excDC2A.ka,
                ke: excDC2A.ke,
                kf: excDC2A.kf,
                ks: excDC2A.ks,
                seefd1: excDC2A.seefd1,
                seefd2: excDC2A.seefd2,
                ta: excDC2A.ta,
                tb: excDC2A.tb,
                tc: excDC2A.tc,
                te: excDC2A.te,
                tf: excDC2A.tf,
                tf1: excDC2A.tf1,
                vrmax: excDC2A.vrmax,
                vrmin: excDC2A.vrmin,
                vtlim: excDC2A.vtlim
            });
        });
    }

    updateExcDC2A = (e) => {
        e.preventDefault();
        let excDC2A = {
            excDC2AId: this.state.id,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            exclim: this.state.exclim,
            ka: this.state.ka,
            ke: this.state.ke,
            kf: this.state.kf,
            ks: this.state.ks,
            seefd1: this.state.seefd1,
            seefd2: this.state.seefd2,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            te: this.state.te,
            tf: this.state.tf,
            tf1: this.state.tf1,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin,
            vtlim: this.state.vtlim
        };
        console.log('excDC2A => ' + JSON.stringify(excDC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC2AService.updateExcDC2A(excDC2A).then( res => {
            this.props.history.push('/excDC2As');
        });
    }

    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
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
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changeseefd1Handler= (event) => {
        this.setState({seefd1: event.target.value});
    }
    changeseefd2Handler= (event) => {
        this.setState({seefd2: event.target.value});
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
    changetf1Handler= (event) => {
        this.setState({tf1: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changevtlimHandler= (event) => {
        this.setState({vtlim: event.target.value});
    }

    cancel(){
        this.props.history.push('/excDC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC2A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> exclim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd2: </label>
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
                                            <label> tf1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vtlim: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC2A}>Save</button>
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

export default UpdateExcDC2AComponent
