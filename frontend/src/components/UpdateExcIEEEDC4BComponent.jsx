import React, { Component } from 'react'
import ExcIEEEDC4BService from '../services/ExcIEEEDC4BService';

class UpdateExcIEEEDC4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efd1: '',
                efd2: '',
                ka: '',
                kd: '',
                ke: '',
                kf: '',
                ki: '',
                kp: '',
                oelin: '',
                seefd1: '',
                seefd2: '',
                ta: '',
                td: '',
                te: '',
                tf: '',
                uelin: '',
                vemin: '',
                vrmax: '',
                vrmin: ''
        }
        this.updateExcIEEEDC4B = this.updateExcIEEEDC4B.bind(this);

        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changeoelinHandler = this.changeoelinHandler.bind(this);
        this.changeseefd1Handler = this.changeseefd1Handler.bind(this);
        this.changeseefd2Handler = this.changeseefd2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changeveminHandler = this.changeveminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEDC4BService.getExcIEEEDC4BById(this.state.id).then( (res) =>{
            let excIEEEDC4B = res.data;
            this.setState({
                efd1: excIEEEDC4B.efd1,
                efd2: excIEEEDC4B.efd2,
                ka: excIEEEDC4B.ka,
                kd: excIEEEDC4B.kd,
                ke: excIEEEDC4B.ke,
                kf: excIEEEDC4B.kf,
                ki: excIEEEDC4B.ki,
                kp: excIEEEDC4B.kp,
                oelin: excIEEEDC4B.oelin,
                seefd1: excIEEEDC4B.seefd1,
                seefd2: excIEEEDC4B.seefd2,
                ta: excIEEEDC4B.ta,
                td: excIEEEDC4B.td,
                te: excIEEEDC4B.te,
                tf: excIEEEDC4B.tf,
                uelin: excIEEEDC4B.uelin,
                vemin: excIEEEDC4B.vemin,
                vrmax: excIEEEDC4B.vrmax,
                vrmin: excIEEEDC4B.vrmin
            });
        });
    }

    updateExcIEEEDC4B = (e) => {
        e.preventDefault();
        let excIEEEDC4B = {
            excIEEEDC4BId: this.state.id,
            efd1: this.state.efd1,
            efd2: this.state.efd2,
            ka: this.state.ka,
            kd: this.state.kd,
            ke: this.state.ke,
            kf: this.state.kf,
            ki: this.state.ki,
            kp: this.state.kp,
            oelin: this.state.oelin,
            seefd1: this.state.seefd1,
            seefd2: this.state.seefd2,
            ta: this.state.ta,
            td: this.state.td,
            te: this.state.te,
            tf: this.state.tf,
            uelin: this.state.uelin,
            vemin: this.state.vemin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin
        };
        console.log('excIEEEDC4B => ' + JSON.stringify(excIEEEDC4B));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEDC4BService.updateExcIEEEDC4B(excIEEEDC4B).then( res => {
            this.props.history.push('/excIEEEDC4Bs');
        });
    }

    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
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
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changeoelinHandler= (event) => {
        this.setState({oelin: event.target.value});
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
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
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
    changeveminHandler= (event) => {
        this.setState({vemin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEDC4Bs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEDC4B</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> oelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> seefd2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vemin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEDC4B}>Save</button>
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

export default UpdateExcIEEEDC4BComponent
