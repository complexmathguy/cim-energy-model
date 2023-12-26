import React, { Component } from 'react'
import WindAeroConstIECService from '../services/WindAeroConstIECService';

class CreateWindAeroConstIECComponent extends Component {
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
            WindAeroConstIECService.getWindAeroConstIECById(this.state.id).then( (res) =>{
                let windAeroConstIEC = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateWindAeroConstIEC = (e) => {
        e.preventDefault();
        let windAeroConstIEC = {
                windAeroConstIECId: this.state.id,
            };
        console.log('windAeroConstIEC => ' + JSON.stringify(windAeroConstIEC));

        // step 5
        if(this.state.id === '_add'){
            windAeroConstIEC.windAeroConstIECId=''
            WindAeroConstIECService.createWindAeroConstIEC(windAeroConstIEC).then(res =>{
                this.props.history.push('/windAeroConstIECs');
            });
        }else{
            WindAeroConstIECService.updateWindAeroConstIEC(windAeroConstIEC).then( res => {
                this.props.history.push('/windAeroConstIECs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/windAeroConstIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindAeroConstIEC</h3>
        }else{
            return <h3 className="text-center">Update WindAeroConstIEC</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindAeroConstIEC}>Save</button>
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

export default CreateWindAeroConstIECComponent
