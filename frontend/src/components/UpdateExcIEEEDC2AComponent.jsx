import React, { Component } from 'react'
import ExcIEEEDC2AService from '../services/ExcIEEEDC2AService';

class UpdateExcIEEEDC2AComponent extends Component {
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
                seefd1: '',
                seefd2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                uelin: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcIEEEDC2A = this.updateExcIEEEDC2A.bind(this);

        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeexclimHandler = this.changeexclimHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeseefd1Handler = this.changeseefd1Handler.bind(this);
        this.changeseefd2Handler = this.changeseefd2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEDC2AService.getExcIEEEDC2AById(this.state.id).then( (res) =>{
            let excIEEEDC2A = res.data;
            this.setState({
                efd1: excIEEEDC2A.efd1,
                efd2: excIEEEDC2A.efd2,
                exclim: excIEEEDC2A.exclim,
                ka: excIEEEDC2A.ka,
                ke: excIEEEDC2A.ke,
                kf: excIEEEDC2A.kf,
                seefd1: excIEEEDC2A.seefd1,
                seefd2: excIEEEDC2A.seefd2,
                ta: excIEEEDC2A.ta,
                tb: excIEEEDC2A.tb,
                tc: excIEEEDC2A.tc,
                te: excIEEEDC2A.te,
                tf: excIEEEDC2A.tf,
                uelin: excIEEEDC2A.uelin,
                vrmax: excIEEEDC2A.vrmax,
                vrmin: excIEEEDC2A.vrmin
            });
        });
    }

    updateExcIEEEDC2A = (e) => {
        e.preventDefault();
        let excIEEEDC2A = {
            excIEEEDC2AId: this.state.id,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            exclim: this.state.exclim,
            ka: this.state.ka,
            ke: this.state.ke,
            kf: this.state.kf,
            seefd1: this.state.seefd1,
            seefd2: this.state.seefd2,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            te: this.state.te,
            tf: this.state.tf,
            uelin: this.state.uelin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excIEEEDC2A => ' + JSON.stringify(excIEEEDC2A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC2AService.updateExcIEEEDC2A(excIEEEDC2A).then( res => {
            this.props.history.push('/excIEEEDC2As');
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
        this.props.history.push('/excIEEEDC2As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC2A</h3>
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
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC2A}>Save</button>
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

export default UpdateExcIEEEDC2AComponent
