import React, { Component } from 'react'
import ExcST3AService from '../services/ExcST3AService';

class UpdateExcST3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdmax: '',
                kc: '',
                kg: '',
                ki: '',
                kj: '',
                km: '',
                kp: '',
                ks: '',
                ks1: '',
                tb: '',
                tc: '',
                thetap: '',
                tm: '',
                vbmax: '',
                vgmax: '',
                vimax: '',
                vimin: '',
                vrmax: '',
                vrmin: '',
                xl: ''
        }
        this.updateExcST3A = this.updateExcST3A.bind(this);

        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekjHandler = this.changekjHandler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changeks1Handler = this.changeks1Handler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changethetapHandler = this.changethetapHandler.bind(this);
        this.changetmHandler = this.changetmHandler.bind(this);
        this.changevbmaxHandler = this.changevbmaxHandler.bind(this);
        this.changevgmaxHandler = this.changevgmaxHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexlHandler = this.changexlHandler.bind(this);
    }

    componentDidMount(){
        ExcST3AService.getExcST3AById(this.state.id).then( (res) =>{
            let excST3A = res.data;
            this.setState({
                efdmax: excST3A.efdmax,
                kc: excST3A.kc,
                kg: excST3A.kg,
                ki: excST3A.ki,
                kj: excST3A.kj,
                km: excST3A.km,
                kp: excST3A.kp,
                ks: excST3A.ks,
                ks1: excST3A.ks1,
                tb: excST3A.tb,
                tc: excST3A.tc,
                thetap: excST3A.thetap,
                tm: excST3A.tm,
                vbmax: excST3A.vbmax,
                vgmax: excST3A.vgmax,
                vimax: excST3A.vimax,
                vimin: excST3A.vimin,
                vrmax: excST3A.vrmax,
                vrmin: excST3A.vrmin,
                xl: excST3A.xl
            });
        });
    }

    updateExcST3A = (e) => {
        e.preventDefault();
        let excST3A = {
            excST3AId: this.state.id,
            efdmax: this.state.efdmax,
            kc: this.state.kc,
            kg: this.state.kg,
            ki: this.state.ki,
            kj: this.state.kj,
            km: this.state.km,
            kp: this.state.kp,
            ks: this.state.ks,
            ks1: this.state.ks1,
            tb: this.state.tb,
            tc: this.state.tc,
            thetap: this.state.thetap,
            tm: this.state.tm,
            vbmax: this.state.vbmax,
            vgmax: this.state.vgmax,
            vimax: this.state.vimax,
            vimin: this.state.vimin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin,
            xl: this.state.xl
        };
        console.log('excST3A => ' + JSON.stringify(excST3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST3AService.updateExcST3A(excST3A).then( res => {
            this.props.history.push('/excST3As');
        });
    }

    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekjHandler= (event) => {
        this.setState({kj: event.target.value});
    }
    changekmHandler= (event) => {
        this.setState({km: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changeks1Handler= (event) => {
        this.setState({ks1: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changethetapHandler= (event) => {
        this.setState({thetap: event.target.value});
    }
    changetmHandler= (event) => {
        this.setState({tm: event.target.value});
    }
    changevbmaxHandler= (event) => {
        this.setState({vbmax: event.target.value});
    }
    changevgmaxHandler= (event) => {
        this.setState({vgmax: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changexlHandler= (event) => {
        this.setState({xl: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kj: </label>
                                            #formFields( $attribute, 'update')
                                            <label> km: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> thetap: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tm: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vbmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vgmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xl: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST3A}>Save</button>
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

export default UpdateExcST3AComponent
