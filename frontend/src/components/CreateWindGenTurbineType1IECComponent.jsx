import React, { Component } from 'react'
import WindGenTurbineType1IECService from '../services/WindGenTurbineType1IECService';

class CreateWindGenTurbineType1IECComponent extends Component {
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
            WindGenTurbineType1IECService.getWindGenTurbineType1IECById(this.state.id).then( (res) =>{
                let windGenTurbineType1IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType1IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType1IEC = {
                windGenTurbineType1IECId: this.state.id,
            };
        console.log('windGenTurbineType1IEC => ' + JSON.stringify(windGenTurbineType1IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType1IEC.windGenTurbineType1IECId=''
            WindGenTurbineType1IECService.createWindGenTurbineType1IEC(windGenTurbineType1IEC).then(res =>{
                this.props.history.push('/windGenTurbineType1IECs');
            });
        }else{
            WindGenTurbineType1IECService.updateWindGenTurbineType1IEC(windGenTurbineType1IEC).then( res => {
                this.props.history.push('/windGenTurbineType1IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windGenTurbineType1IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType1IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType1IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType1IEC}>Save</button>
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

export default CreateWindGenTurbineType1IECComponent
