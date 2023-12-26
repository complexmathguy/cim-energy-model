import React, { Component } from 'react'
import ExcHUService from '../services/ExcHUService';

class CreateExcHUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateExcHU = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            excHU.excHUId=''
            ExcHUService.createExcHU(excHU).then(res =>{
                this.props.history.push('/excHUs');
            });
        }else{
            ExcHUService.updateExcHU(excHU).then( res => {
                this.props.history.push('/excHUs');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcHU</h3>
        }else{
            return <h3 className="text-center">Update ExcHU</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> ae: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ai: </label>
                                            #formFields( $attribute, 'create')
                                            <label> atr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> imax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> imin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ti: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tr: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcHU}>Save</button>
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

export default CreateExcHUComponent
