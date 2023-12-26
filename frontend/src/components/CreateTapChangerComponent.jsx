import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService';

class CreateTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                highStep: '',
                lowStep: '',
                ltcFlag: '',
                neutralStep: '',
                neutralU: '',
                normalStep: ''
        }
        this.changehighStepHandler = this.changehighStepHandler.bind(this);
        this.changelowStepHandler = this.changelowStepHandler.bind(this);
        this.changeltcFlagHandler = this.changeltcFlagHandler.bind(this);
        this.changeneutralStepHandler = this.changeneutralStepHandler.bind(this);
        this.changeneutralUHandler = this.changeneutralUHandler.bind(this);
        this.changenormalStepHandler = this.changenormalStepHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TapChangerService.getTapChangerById(this.state.id).then( (res) =>{
                let tapChanger = res.data;
                this.setState({
                    highStep: tapChanger.highStep,
                    lowStep: tapChanger.lowStep,
                    ltcFlag: tapChanger.ltcFlag,
                    neutralStep: tapChanger.neutralStep,
                    neutralU: tapChanger.neutralU,
                    normalStep: tapChanger.normalStep
                });
            });
        }        
    }
    saveOrUpdateTapChanger = (e) => {
        e.preventDefault();
        let tapChanger = {
                tapChangerId: this.state.id,
                highStep: this.state.highStep,
                lowStep: this.state.lowStep,
                ltcFlag: this.state.ltcFlag,
                neutralStep: this.state.neutralStep,
                neutralU: this.state.neutralU,
                normalStep: this.state.normalStep
            };
        console.log('tapChanger => ' + JSON.stringify(tapChanger));

        // step 5
        if(this.state.id === '_add'){
            tapChanger.tapChangerId=''
            TapChangerService.createTapChanger(tapChanger).then(res =>{
                this.props.history.push('/tapChangers');
            });
        }else{
            TapChangerService.updateTapChanger(tapChanger).then( res => {
                this.props.history.push('/tapChangers');
            });
        }
    }
    
    changehighStepHandler= (event) => {
        this.setState({highStep: event.target.value});
    }
    changelowStepHandler= (event) => {
        this.setState({lowStep: event.target.value});
    }
    changeltcFlagHandler= (event) => {
        this.setState({ltcFlag: event.target.value});
    }
    changeneutralStepHandler= (event) => {
        this.setState({neutralStep: event.target.value});
    }
    changeneutralUHandler= (event) => {
        this.setState({neutralU: event.target.value});
    }
    changenormalStepHandler= (event) => {
        this.setState({normalStep: event.target.value});
    }

    cancel(){
        this.props.history.push('/tapChangers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapChanger</h3>
        }else{
            return <h3 className="text-center">Update TapChanger</h3>
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
                                            <label> highStep: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lowStep: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ltcFlag: </label>
                                            #formFields( $attribute, 'create')
                                            <label> neutralStep: </label>
                                            #formFields( $attribute, 'create')
                                            <label> neutralU: </label>
                                            #formFields( $attribute, 'create')
                                            <label> normalStep: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapChanger}>Save</button>
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

export default CreateTapChangerComponent
