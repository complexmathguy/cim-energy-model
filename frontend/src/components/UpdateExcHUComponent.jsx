import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService';

class UpdateExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                ae: '',
                ai: '',
                atr: '',
                emax: '',
                emin: '',
                imax: '',
                imin: '',
                ke: '',
                ki: '',
                te: '',
                ti: '',
                tr: ''
        }
        this.updateExcHU = this.updateExcHU.bind(this);

        this.changeaeHandler = this.changeaeHandler.bind(this);
        this.changeaiHandler = this.changeaiHandler.bind(this);
        this.changeatrHandler = this.changeatrHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changeeminHandler = this.changeeminHandler.bind(this);
        this.changeimaxHandler = this.changeimaxHandler.bind(this);
        this.changeiminHandler = this.changeiminHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetiHandler = this.changetiHandler.bind(this);
        this.changetrHandler = this.changetrHandler.bind(this);
    }

    componentDidMount(){
        ExcHUService.getExcHUById(this.state.id).then( (res) =>{
            let excHU = res.data;
            this.setState({
                ae: excHU.ae,
                ai: excHU.ai,
                atr: excHU.atr,
                emax: excHU.emax,
                emin: excHU.emin,
                imax: excHU.imax,
                imin: excHU.imin,
                ke: excHU.ke,
                ki: excHU.ki,
                te: excHU.te,
                ti: excHU.ti,
                tr: excHU.tr
            });
        });
    }

    updateExcHU = (e) => {
        e.preventDefault();
        let excHU = {
            excHUId: this.state.id,
            ae: this.state.ae,
            ai: this.state.ai,
            atr: this.state.atr,
            emax: this.state.emax,
            emin: this.state.emin,
            imax: this.state.imax,
            imin: this.state.imin,
            ke: this.state.ke,
            ki: this.state.ki,
            te: this.state.te,
            ti: this.state.ti,
            tr: this.state.tr
        };
        console.log('excHU => ' + JSON.stringify(excHU));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcHUService.updateExcHU(excHU).then( res => {
            this.props.history.push('/excHUs');
        });
    }

    changeaeHandler= (event) => {
        this.setState({ae: event.target.value});
    }
    changeaiHandler= (event) => {
        this.setState({ai: event.target.value});
    }
    changeatrHandler= (event) => {
        this.setState({atr: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changeeminHandler= (event) => {
        this.setState({emin: event.target.value});
    }
    changeimaxHandler= (event) => {
        this.setState({imax: event.target.value});
    }
    changeiminHandler= (event) => {
        this.setState({imin: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetiHandler= (event) => {
        this.setState({ti: event.target.value});
    }
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }

    cancel(){
        this.props.history.push('/excHUs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcHU</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ae: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ai: </label>
                                            #formFields( $attribute, 'update')
                                            <label> atr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> imax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> imin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcHU}>Save</button>
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

export default UpdateExcHUComponent
