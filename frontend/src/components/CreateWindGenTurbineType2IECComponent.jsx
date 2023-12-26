import React, { Component } from 'react'
import WindGenTurbineType2IECService from '../services/WindGenTurbineType2IECService';

class CreateWindGenTurbineType2IECComponent extends Component {
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
            WindGenTurbineType2IECService.getWindGenTurbineType2IECById(this.state.id).then( (res) =>{
                let windGenTurbineType2IEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindGenTurbineType2IEC = (e) => {
        e.preventDefault();
        let windGenTurbineType2IEC = {
                windGenTurbineType2IECId: this.state.id,
            };
        console.log('windGenTurbineType2IEC => ' + JSON.stringify(windGenTurbineType2IEC));

        // step 5
        if(this.state.id === '_add'){
            windGenTurbineType2IEC.windGenTurbineType2IECId=''
            WindGenTurbineType2IECService.createWindGenTurbineType2IEC(windGenTurbineType2IEC).then(res =>{
                this.props.history.push('/windGenTurbineType2IECs');
            });
        }else{
            WindGenTurbineType2IECService.updateWindGenTurbineType2IEC(windGenTurbineType2IEC).then( res => {
                this.props.history.push('/windGenTurbineType2IECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windGenTurbineType2IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindGenTurbineType2IEC</h3>
        }else{
            return <h3 className="text-center">Update WindGenTurbineType2IEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindGenTurbineType2IEC}>Save</button>
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

export default CreateWindGenTurbineType2IECComponent
