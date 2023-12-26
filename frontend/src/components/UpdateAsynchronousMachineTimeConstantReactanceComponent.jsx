import React, { Component } from 'react'
import AsynchronousMachineTimeConstantReactanceService from '../services/AsynchronousMachineTimeConstantReactanceService';

class UpdateAsynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                tpo: '',
                tppo: '',
                xp: '',
                xpp: '',
                xs: ''
        }
        this.updateAsynchronousMachineTimeConstantReactance = this.updateAsynchronousMachineTimeConstantReactance.bind(this);

        this.changetpoHandler = this.changetpoHandler.bind(this);
        this.changetppoHandler = this.changetppoHandler.bind(this);
        this.changexpHandler = this.changexpHandler.bind(this);
        this.changexppHandler = this.changexppHandler.bind(this);
        this.changexsHandler = this.changexsHandler.bind(this);
    }

    componentDidMount(){
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

    updateAsynchronousMachineTimeConstantReactance = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        AsynchronousMachineTimeConstantReactanceService.updateAsynchronousMachineTimeConstantReactance(asynchronousMachineTimeConstantReactance).then( res => {
            this.props.history.push('/asynchronousMachineTimeConstantReactances');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AsynchronousMachineTimeConstantReactance</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> tpo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tppo: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xs: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAsynchronousMachineTimeConstantReactance}>Save</button>
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

export default UpdateAsynchronousMachineTimeConstantReactanceComponent
