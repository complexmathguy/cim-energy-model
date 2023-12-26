import React, { Component } from 'react'
import ExcDC1AService from '../services/ExcDC1AService';

class UpdateExcDC1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                edfmax: '',
                efd1: '',
                efd2: '',
                efdmin: '',
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
                vrmax: '',
                vrmin: ''
        }
        this.updateExcDC1A = this.updateExcDC1A.bind(this);

        this.changeedfmaxHandler = this.changeedfmaxHandler.bind(this);
        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
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
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcDC1AService.getExcDC1AById(this.state.id).then( (res) =>{
            let excDC1A = res.data;
            this.setState({
                edfmax: excDC1A.edfmax,
                efd1: excDC1A.efd1,
                efd2: excDC1A.efd2,
                efdmin: excDC1A.efdmin,
                exclim: excDC1A.exclim,
                ka: excDC1A.ka,
                ke: excDC1A.ke,
                kf: excDC1A.kf,
                ks: excDC1A.ks,
                seefd1: excDC1A.seefd1,
                seefd2: excDC1A.seefd2,
                ta: excDC1A.ta,
                tb: excDC1A.tb,
                tc: excDC1A.tc,
                te: excDC1A.te,
                tf: excDC1A.tf,
                vrmax: excDC1A.vrmax,
                vrmin: excDC1A.vrmin
            });
        });
    }

    updateExcDC1A = (e) => {
        e.preventDefault();
        let excDC1A = {
            excDC1AId: this.state.id,
            edfmax: this.state.edfmax,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            efdmin: this.state.efdmin,
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
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excDC1A => ' + JSON.stringify(excDC1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcDC1AService.updateExcDC1A(excDC1A).then( res => {
            this.props.history.push('/excDC1As');
        });
    }

    changeedfmaxHandler= (event) => {
        this.setState({edfmax: event.target.value});
    }
    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
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
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excDC1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcDC1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> edfmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efdmin: </label>
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
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcDC1A}>Save</button>
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

export default UpdateExcDC1AComponent
