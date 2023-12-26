import React, { Component } from 'react'
import TapChangerControlService from '../services/TapChangerControlService';

class CreateTapChangerControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            TapChangerControlService.getTapChangerControlById(this.state.id).then( (res) =>{
                let tapChangerControl = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateTapChangerControl = (e) => {
        e.preventDefault();
        let tapChangerControl = {
                tapChangerControlId: this.state.id,
            };
        console.log('tapChangerControl => ' + JSON.stringify(tapChangerControl));

        // step 5
        if(this.state.id === '_add'){
            tapChangerControl.tapChangerControlId=''
            TapChangerControlService.createTapChangerControl(tapChangerControl).then(res =>{
                this.props.history.push('/tapChangerControls');
            });
        }else{
            TapChangerControlService.updateTapChangerControl(tapChangerControl).then( res => {
                this.props.history.push('/tapChangerControls');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/tapChangerControls');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add TapChangerControl</h3>
        }else{
            return <h3 className="text-center">Update TapChangerControl</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateTapChangerControl}>Save</button>
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

export default CreateTapChangerControlComponent
