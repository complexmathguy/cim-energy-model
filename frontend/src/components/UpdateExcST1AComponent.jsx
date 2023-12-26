import React, { Component } from 'react'
import ExcST1AService from '../services/ExcST1AService';

class UpdateExcST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ilr: '',
                ka: '',
                kc: '',
                kf: '',
                klr: '',
                ta: '',
                tb: '',
                tb1: '',
                tc: '',
                tc1: '',
                tf: '',
                vamax: '',
                vamin: '',
                vimax: '',
                vimin: '',
                vrmax: '',
                vrmin: '',
                xe: ''
        }
        this.updateExcST1A = this.updateExcST1A.bind(this);

        this.changeilrHandler = this.changeilrHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeklrHandler = this.changeklrHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetb1Handler = this.changetb1Handler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetc1Handler = this.changetc1Handler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexeHandler = this.changexeHandler.bind(this);
    }

    componentDidMount(){
        ExcST1AService.getExcST1AById(this.state.id).then( (res) =>{
            let excST1A = res.data;
            this.setState({
                ilr: excST1A.ilr,
                ka: excST1A.ka,
                kc: excST1A.kc,
                kf: excST1A.kf,
                klr: excST1A.klr,
                ta: excST1A.ta,
                tb: excST1A.tb,
                tb1: excST1A.tb1,
                tc: excST1A.tc,
                tc1: excST1A.tc1,
                tf: excST1A.tf,
                vamax: excST1A.vamax,
                vamin: excST1A.vamin,
                vimax: excST1A.vimax,
                vimin: excST1A.vimin,
                vrmax: excST1A.vrmax,
                vrmin: excST1A.vrmin,
                xe: excST1A.xe
            });
        });
    }

    updateExcST1A = (e) => {
        e.preventDefault();
        let excST1A = {
            excST1AId: this.state.id,
            ilr: this.state.ilr,
            ka: this.state.ka,
            kc: this.state.kc,
            kf: this.state.kf,
            klr: this.state.klr,
            ta: this.state.ta,
            tb: this.state.tb,
            tb1: this.state.tb1,
            tc: this.state.tc,
            tc1: this.state.tc1,
            tf: this.state.tf,
            vamax: this.state.vamax,
            vamin: this.state.vamin,
            vimax: this.state.vimax,
            vimin: this.state.vimin,
            vrmax: this.state.vrmax,
            vrmin: this.state.vrmin,
            xe: this.state.xe
        };
        console.log('excST1A => ' + JSON.stringify(excST1A));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcST1AService.updateExcST1A(excST1A).then( res => {
            this.props.history.push('/excST1As');
        });
    }

    changeilrHandler= (event) => {
        this.setState({ilr: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changeklrHandler= (event) => {
        this.setState({klr: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetb1Handler= (event) => {
        this.setState({tb1: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetc1Handler= (event) => {
        this.setState({tc1: event.target.value});
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
    changexeHandler= (event) => {
        this.setState({xe: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST1As');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcST1A</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ilr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> klr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xe: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcST1A}>Save</button>
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

export default UpdateExcST1AComponent
