import React, { Component } from 'react'
import TapChangerService from '../services/TapChangerService';

class UpdateTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                highStep: '',
                lowStep: '',
                ltcFlag: '',
                neutralStep: '',
                neutralU: '',
                normalStep: ''
        }
        this.updateTapChanger = this.updateTapChanger.bind(this);

        this.changehighStepHandler = this.changehighStepHandler.bind(this);
        this.changelowStepHandler = this.changelowStepHandler.bind(this);
        this.changeltcFlagHandler = this.changeltcFlagHandler.bind(this);
        this.changeneutralStepHandler = this.changeneutralStepHandler.bind(this);
        this.changeneutralUHandler = this.changeneutralUHandler.bind(this);
        this.changenormalStepHandler = this.changenormalStepHandler.bind(this);
    }

    componentDidMount(){
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

    updateTapChanger = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        TapChangerService.updateTapChanger(tapChanger).then( res => {
            this.props.history.push('/tapChangers');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapChanger</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> highStep: </label>
                                            #formFields( $attribute, 'update')
                                            <label> lowStep: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ltcFlag: </label>
                                            #formFields( $attribute, 'update')
                                            <label> neutralStep: </label>
                                            #formFields( $attribute, 'update')
                                            <label> neutralU: </label>
                                            #formFields( $attribute, 'update')
                                            <label> normalStep: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapChanger}>Save</button>
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

export default UpdateTapChangerComponent
