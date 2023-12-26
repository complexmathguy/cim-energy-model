import React, { Component } from 'react'
import WindTurbineType4aIECService from '../services/WindTurbineType4aIECService';

class CreateWindTurbineType4aIECComponent extends Component {
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
            WindTurbineType4aIECService.getWindTurbineType4aIECById(this.state.id).then( (res) =>{
                let windTurbineType4aIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType4aIEC = (e) => {
        e.preventDefault();
        let windTurbineType4aIEC = {
                windTurbineType4aIECId: this.state.id,
            };
        console.log('windTurbineType4aIEC => ' + JSON.stringify(windTurbineType4aIEC));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType4aIEC.windTurbineType4aIECId=''
            WindTurbineType4aIECService.createWindTurbineType4aIEC(windTurbineType4aIEC).then(res =>{
                this.props.history.push('/windTurbineType4aIECs');
            });
        }else{
            WindTurbineType4aIECService.updateWindTurbineType4aIEC(windTurbineType4aIEC).then( res => {
                this.props.history.push('/windTurbineType4aIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType4aIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType4aIEC</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType4aIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType4aIEC}>Save</button>
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

export default CreateWindTurbineType4aIECComponent
