import React, { Component } from 'react'
import DCBusbarService from '../services/DCBusbarService';

class CreateDCBusbarComponent extends Component {
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
            DCBusbarService.getDCBusbarById(this.state.id).then( (res) =>{
                let dCBusbar = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDCBusbar = (e) => {
        e.preventDefault();
        let dCBusbar = {
                dCBusbarId: this.state.id,
            };
        console.log('dCBusbar => ' + JSON.stringify(dCBusbar));

        // step 5
        if(this.state.id === '_add'){
            dCBusbar.dCBusbarId=''
            DCBusbarService.createDCBusbar(dCBusbar).then(res =>{
                this.props.history.push('/dCBusbars');
            });
        }else{
            DCBusbarService.updateDCBusbar(dCBusbar).then( res => {
                this.props.history.push('/dCBusbars');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dCBusbars');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCBusbar</h3>
        }else{
            return <h3 className="text-center">Update DCBusbar</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCBusbar}>Save</button>
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

export default CreateDCBusbarComponent
