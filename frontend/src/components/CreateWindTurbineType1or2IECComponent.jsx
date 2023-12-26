import React, { Component } from 'react'
import WindTurbineType1or2IECService from '../services/WindTurbineType1or2IECService';

class CreateWindTurbineType1or2IECComponent extends Component {
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
            WindTurbineType1or2IECService.getWindTurbineType1or2IECById(this.state.id).then( (res) =>{
                let windTurbineType1or2IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindTurbineType1or2IEC = (e) => {
        e.preventDefault();
        let windTurbineType1or2IEC = {
                windTurbineType1or2IECId: this.state.id,
            };
        console.log('windTurbineType1or2IEC => ' + JSON.stringify(windTurbineType1or2IEC));

        // step 5
        if(this.state.id === '_add'){
            windTurbineType1or2IEC.windTurbineType1or2IECId=''
            WindTurbineType1or2IECService.createWindTurbineType1or2IEC(windTurbineType1or2IEC).then(res =>{
                this.props.history.push('/windTurbineType1or2IECs');
            });
        }else{
            WindTurbineType1or2IECService.updateWindTurbineType1or2IEC(windTurbineType1or2IEC).then( res => {
                this.props.history.push('/windTurbineType1or2IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windTurbineType1or2IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindTurbineType1or2IEC</h3>
        }else{
            return <h3 className="text-center">Update WindTurbineType1or2IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindTurbineType1or2IEC}>Save</button>
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

export default CreateWindTurbineType1or2IECComponent
