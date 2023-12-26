import React, { Component } from 'react'
import WindPlantIECService from '../services/WindPlantIECService';

class CreateWindPlantIECComponent extends Component {
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
            WindPlantIECService.getWindPlantIECById(this.state.id).then( (res) =>{
                let windPlantIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindPlantIEC = (e) => {
        e.preventDefault();
        let windPlantIEC = {
                windPlantIECId: this.state.id,
            };
        console.log('windPlantIEC => ' + JSON.stringify(windPlantIEC));

        // step 5
        if(this.state.id === '_add'){
            windPlantIEC.windPlantIECId=''
            WindPlantIECService.createWindPlantIEC(windPlantIEC).then(res =>{
                this.props.history.push('/windPlantIECs');
            });
        }else{
            WindPlantIECService.updateWindPlantIEC(windPlantIEC).then( res => {
                this.props.history.push('/windPlantIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windPlantIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPlantIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantIEC}>Save</button>
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

export default CreateWindPlantIECComponent
