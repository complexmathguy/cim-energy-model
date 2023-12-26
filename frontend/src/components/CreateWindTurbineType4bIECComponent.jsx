import React, { Component } from 'react'
import WindTurbineType4bIECService from '../services/WindTurbineType4bIECService';

class CreateWindTurbineType4bIECComponent extends Component {
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
            WindTurbineType4bIECService.getWindTurbineType4bIECById(this.state.id).then( (res) =>{
                let windTurbineType4bIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType4bIEC = (e) => {
        e.preventDefault();
        let windTurbineType4bIEC = {
                windTurbineType4bIECId: this.state.id,
            };
        console.log('windTurbineType4bIEC => ' + JSON.stringify(windTurbineType4bIEC));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType4bIEC.windTurbineType4bIECId=''
            WindTurbineType4bIECService.createWindTurbineType4bIEC(windTurbineType4bIEC).then(res =>{
                this.props.history.push('/windTurbineType4bIECs');
            });
        }else{
            WindTurbineType4bIECService.updateWindTurbineType4bIEC(windTurbineType4bIEC).then( res => {
                this.props.history.push('/windTurbineType4bIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType4bIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType4bIEC</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType4bIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType4bIEC}>Save</button>
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

export default CreateWindTurbineType4bIECComponent
