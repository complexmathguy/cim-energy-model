import React, { Component } from 'react'
import VsConverterService from '../services/VsConverterService';

class UpdateVsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                maxModulationIndex: '',
                maxValveCurrent: ''
        }
        this.updateVsConverter = this.updateVsConverter.bind(this);

        this.changemaxModulationIndexHandler = this.changemaxModulationIndexHandler.bind(this);
        this.changemaxValveCurrentHandler = this.changemaxValveCurrentHandler.bind(this);
    }

    componentDidMount(){
        VsConverterService.getVsConverterById(this.state.id).then( (res) =>{
            let vsConverter = res.data;
            this.setState({
                maxModulationIndex: vsConverter.maxModulationIndex,
                maxValveCurrent: vsConverter.maxValveCurrent
            });
        });
    }

    updateVsConverter = (e) => {
        e.preventDefault();
        let vsConverter = {
            vsConverterId: this.state.id,
            maxModulationIndex: this.state.maxModulationIndex,
            maxValveCurrent: this.state.maxValveCurrent
        };
        console.log('vsConverter => ' + JSON.stringify(vsConverter));
        console.log('id => ' + JSON.stringify(this.state.id));
        VsConverterService.updateVsConverter(vsConverter).then( res => {
            this.props.history.push('/vsConverters');
        });
    }

    changemaxModulationIndexHandler= (event) => {
        this.setState({maxModulationIndex: event.target.value});
    }
    changemaxValveCurrentHandler= (event) => {
        this.setState({maxValveCurrent: event.target.value});
    }

    cancel(){
        this.props.history.push('/vsConverters');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update VsConverter</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> maxModulationIndex: </label>
                                            #formFields( $attribute, 'update')
                                            <label> maxValveCurrent: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateVsConverter}>Save</button>
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

export default UpdateVsConverterComponent
