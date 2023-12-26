import React, { Component } from 'react'
import TurbLCFB1Service from '../services/TurbLCFB1Service';

class CreateTurbLCFB1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                db: '',
                emax: '',
                fb: '',
                fbf: '',
                irmax: '',
                ki: '',
                kp: '',
                mwbase: '',
                pbf: '',
                pmwset: '',
                speedReferenceGovernor: '',
                tpelec: ''
        }
        this.changedbHandler = this.changedbHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changefbHandler = this.changefbHandler.bind(this);
        this.changefbfHandler = this.changefbfHandler.bind(this);
        this.changeirmaxHandler = this.changeirmaxHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepbfHandler = this.changepbfHandler.bind(this);
        this.changepmwsetHandler = this.changepmwsetHandler.bind(this);
        this.changespeedReferenceGovernorHandler = this.changespeedReferenceGovernorHandler.bind(this);
        this.changetpelecHandler = this.changetpelecHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TurbLCFB1Service.getTurbLCFB1ById(this.state.id).then( (res) =>{
                let turbLCFB1 = res.data;
                this.setState({
                    db: turbLCFB1.db,
                    emax: turbLCFB1.emax,
                    fb: turbLCFB1.fb,
                    fbf: turbLCFB1.fbf,
                    irmax: turbLCFB1.irmax,
                    ki: turbLCFB1.ki,
                    kp: turbLCFB1.kp,
                    mwbase: turbLCFB1.mwbase,
                    pbf: turbLCFB1.pbf,
                    pmwset: turbLCFB1.pmwset,
                    speedReferenceGovernor: turbLCFB1.speedReferenceGovernor,
                    tpelec: turbLCFB1.tpelec
                });
            });
        }        
    }
    saveOrUpdateTurbLCFB1 = (e) => {
        e.preventDefault();
        let turbLCFB1 = {
                turbLCFB1Id: this.state.id,
                db: this.state.db,
                emax: this.state.emax,
                fb: this.state.fb,
                fbf: this.state.fbf,
                irmax: this.state.irmax,
                ki: this.state.ki,
                kp: this.state.kp,
                mwbase: this.state.mwbase,
                pbf: this.state.pbf,
                pmwset: this.state.pmwset,
                speedReferenceGovernor: this.state.speedReferenceGovernor,
                tpelec: this.state.tpelec
            };
        console.log('turbLCFB1 => ' + JSON.stringify(turbLCFB1));

        // step 5
        if(this.state.id === '_add'){
            turbLCFB1.turbLCFB1Id=''
            TurbLCFB1Service.createTurbLCFB1(turbLCFB1).then(res =>{
                this.props.history.push('/turbLCFB1s');
            });
        }else{
            TurbLCFB1Service.updateTurbLCFB1(turbLCFB1).then( res => {
                this.props.history.push('/turbLCFB1s');
            });
        }
    }
    
    changedbHandler= (event) => {
        this.setState({db: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changefbHandler= (event) => {
        this.setState({fb: event.target.value});
    }
    changefbfHandler= (event) => {
        this.setState({fbf: event.target.value});
    }
    changeirmaxHandler= (event) => {
        this.setState({irmax: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepbfHandler= (event) => {
        this.setState({pbf: event.target.value});
    }
    changepmwsetHandler= (event) => {
        this.setState({pmwset: event.target.value});
    }
    changespeedReferenceGovernorHandler= (event) => {
        this.setState({speedReferenceGovernor: event.target.value});
    }
    changetpelecHandler= (event) => {
        this.setState({tpelec: event.target.value});
    }

    cancel(){
        this.props.history.push('/turbLCFB1s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TurbLCFB1</h3>
        }else{
            return <h3 className="text-center">Update TurbLCFB1</h3>
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
                                            <label> db: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> fbf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> irmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pbf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmwset: </label>
                                            #formFields( $attribute, 'create')
                                            <label> speedReferenceGovernor: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpelec: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTurbLCFB1}>Save</button>
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

export default CreateTurbLCFB1Component
