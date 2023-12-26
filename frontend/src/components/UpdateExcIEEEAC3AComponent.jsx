import React, { Component } from 'react'
import ExcIEEEAC3AService from '../services/ExcIEEEAC3AService';

class UpdateExcIEEEAC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                efdn: '',
                ka: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                kn: '',
                kr: '',
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
                vemin: '',
                vfemax: ''
        }
        this.updateExcIEEEAC3A = this.updateExcIEEEAC3A.bind(this);

        this.changeefdnHandler = this.changeefdnHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeknHandler = this.changeknHandler.bind(this);
        this.changekrHandler = this.changekrHandler.bind(this);
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
        this.changeveminHandler = this.changeveminHandler.bind(this);
        this.changevfemaxHandler = this.changevfemaxHandler.bind(this);
    }

    componentDidMount(){
        ExcIEEEAC3AService.getExcIEEEAC3AById(this.state.id).then( (res) =>{
            let excIEEEAC3A = res.data;
            this.setState({
                efdn: excIEEEAC3A.efdn,
                ka: excIEEEAC3A.ka,
                kc: excIEEEAC3A.kc,
                kd: excIEEEAC3A.kd,
                ke: excIEEEAC3A.ke,
                kf: excIEEEAC3A.kf,
                kn: excIEEEAC3A.kn,
                kr: excIEEEAC3A.kr,
                seve1: excIEEEAC3A.seve1,
                seve2: excIEEEAC3A.seve2,
                ta: excIEEEAC3A.ta,
                tb: excIEEEAC3A.tb,
                tc: excIEEEAC3A.tc,
                te: excIEEEAC3A.te,
                tf: excIEEEAC3A.tf,
                vamax: excIEEEAC3A.vamax,
                vamin: excIEEEAC3A.vamin,
                ve1: excIEEEAC3A.ve1,
                ve2: excIEEEAC3A.ve2,
                vemin: excIEEEAC3A.vemin,
                vfemax: excIEEEAC3A.vfemax
            });
        });
    }

    updateExcIEEEAC3A = (e) => {
        e.preventDefault();
        let excIEEEAC3A = {
            excIEEEAC3AId: this.state.id,
            efdn: this.state.efdn,
            ka: this.state.ka,
            kc: this.state.kc,
            kd: this.state.kd,
            ke: this.state.ke,
            kf: this.state.kf,
            kn: this.state.kn,
            kr: this.state.kr,
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
            vemin: this.state.vemin,
            vfemax: this.state.vfemax
        };
        console.log('excIEEEAC3A => ' + JSON.stringify(excIEEEAC3A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcIEEEAC3AService.updateExcIEEEAC3A(excIEEEAC3A).then( res => {
            this.props.history.push('/excIEEEAC3As');
        });
    }

    changeefdnHandler= (event) => {
        this.setState({efdn: event.target.value});
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
    changeknHandler= (event) => {
        this.setState({kn: event.target.value});
    }
    changekrHandler= (event) => {
        this.setState({kr: event.target.value});
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
    changeveminHandler= (event) => {
        this.setState({vemin: event.target.value});
    }
    changevfemaxHandler= (event) => {
        this.setState({vfemax: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEAC3As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcIEEEAC3A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdn: </label>
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
                                            <label> kn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kr: </label>
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
                                            <label> vemin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vfemax: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcIEEEAC3A}>Save</button>
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

export default UpdateExcIEEEAC3AComponent
