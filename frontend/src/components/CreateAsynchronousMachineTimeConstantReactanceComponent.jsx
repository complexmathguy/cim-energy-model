import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService';

class CreateAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                tpo: '',
                tppo: '',
                xp: '',
                xpp: '',
                xs: ''
        }
        this.changetpoHandler = this.changetpoHandler.bind(this);
        this.changetppoHandler = this.changetppoHandler.bind(this);
        this.changexpHandler = this.changexpHandler.bind(this);
        this.changexppHandler = this.changexppHandler.bind(this);
        this.changexsHandler = this.changexsHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AsynchronousMachineTimeConstantReactanceService.getAsynchronousMachineTimeConstantReactanceById(this.state.id).then( (res) =>{
                let asynchronousMachineTimeConstantReactance = res.data;
                this.setState({
                    tpo: asynchronousMachineTimeConstantReactance.tpo,
                    tppo: asynchronousMachineTimeConstantReactance.tppo,
                    xp: asynchronousMachineTimeConstantReactance.xp,
                    xpp: asynchronousMachineTimeConstantReactance.xpp,
                    xs: asynchronousMachineTimeConstantReactance.xs
                });
            });
        }        
    }
    saveOrUpdateAsynchronousMachineTimeConstantReactance = (e) => {
        e.preventDefault();
        let asynchronousMachineTimeConstantReactance = {
                asynchronousMachineTimeConstantReactanceId: this.state.id,
                tpo: this.state.tpo,
                tppo: this.state.tppo,
                xp: this.state.xp,
                xpp: this.state.xpp,
                xs: this.state.xs
            };
        console.log('asynchronousMachineTimeConstantReactance => ' + JSON.stringify(asynchronousMachineTimeConstantReactance));

        // step 5
        if(this.state.id === '_add'){
            asynchronousMachineTimeConstantReactance.asynchronousMachineTimeConstantReactanceId=''
            AsynchronousMachineTimeConstantReactanceService.createAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then(res =>{
                this.props.history.push('/asynchronousMachineTimeConstantReactances');
            });
        }else{
            AsynchronousMachineTimeConstantReactanceService.updateAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then( res => {
                this.props.history.push('/asynchronousMachineTimeConstantReactances');
            });
        }
    }
    
    changetpoHandler= (event) => {
        this.setState({tpo: event.target.value});
    }
    changetppoHandler= (event) => {
        this.setState({tppo: event.target.value});
    }
    changexpHandler= (event) => {
        this.setState({xp: event.target.value});
    }
    changexppHandler= (event) => {
        this.setState({xpp: event.target.value});
    }
    changexsHandler= (event) => {
        this.setState({xs: event.target.value});
    }

    cancel(){
        this.props.history.push('/asynchronousMachineTimeConstantReactances');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add AsynchronousMachineTimeConstantReactance</h3>
        }else{
            return <h3 className="text-center">Update AsynchronousMachineTimeConstantReactance</h3>
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
                                            <label> tpo: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tppo: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xpp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xs: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAsynchronousMachineTimeConstantReactance}>Save</button>
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

export default CreateAsynchronousMachineTimeConstantReactanceComponent
