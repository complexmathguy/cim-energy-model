import React, { Component } from 'react'
import WindTurbineType3or4IECService from '../services/WindTurbineType3or4IECService';

class CreateWindTurbineType3or4IECComponent extends Component {
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
            WindTurbineType3or4IECService.getWindTurbineType3or4IECById(this.state.id).then( (res) =>{
                let windTurbineType3or4IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType3or4IEC = (e) => {
        e.preventDefault();
        let windTurbineType3or4IEC = {
                windTurbineType3or4IECId: this.state.id,
            };
        console.log('windTurbineType3or4IEC => ' + JSON.stringify(windTurbineType3or4IEC));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType3or4IEC.windTurbineType3or4IECId=''
            WindTurbineType3or4IECService.createWindTurbineType3or4IEC(windTurbineType3or4IEC).then(res =>{
                this.props.history.push('/windTurbineType3or4IECs');
            });
        }else{
            WindTurbineType3or4IECService.updateWindTurbineType3or4IEC(windTurbineType3or4IEC).then( res => {
                this.props.history.push('/windTurbineType3or4IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType3or4IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType3or4IEC</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType3or4IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType3or4IEC}>Save</button>
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

export default CreateWindTurbineType3or4IECComponent
