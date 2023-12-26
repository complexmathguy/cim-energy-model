import React, { Component } from 'react'
import VsConverterService from '../services/VsConverterService';

class CreateVsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                maxModulationIndex: '',
                maxValveCurrent: ''
        }
        this.changemaxModulationIndexHandler = this.changemaxModulationIndexHandler.bind(this);
        this.changemaxValveCurrentHandler = this.changemaxValveCurrentHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VsConverterService.getVsConverterById(this.state.id).then( (res) =>{
                let vsConverter = res.data;
                this.setState({
                    maxModulationIndex: vsConverter.maxModulationIndex,
                    maxValveCurrent: vsConverter.maxValveCurrent
                });
            });
        }        
    }
    saveOrUpdateVsConverter = (e) => {
        e.preventDefault();
        let vsConverter = {
                vsConverterId: this.state.id,
                maxModulationIndex: this.state.maxModulationIndex,
                maxValveCurrent: this.state.maxValveCurrent
            };
        console.log('vsConverter => ' + JSON.stringify(vsConverter));

        // step 5
        if(this.state.id === '_add'){
            vsConverter.vsConverterId=''
            VsConverterService.createVsConverter(vsConverter).then(res =>{
                this.props.history.push('/vsConverters');
            });
        }else{
            VsConverterService.updateVsConverter(vsConverter).then( res => {
                this.props.history.push('/vsConverters');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VsConverter</h3>
        }else{
            return <h3 className="text-center">Update VsConverter</h3>
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
                                            <label> maxModulationIndex: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxValveCurrent: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVsConverter}>Save</button>
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

export default CreateVsConverterComponent
