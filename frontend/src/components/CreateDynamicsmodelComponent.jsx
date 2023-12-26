import React, { Component } from 'react'
import DynamicsmodelService from '../services/DynamicsmodelService';

class CreateDynamicsmodelComponent extends Component {
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
            DynamicsmodelService.getDynamicsmodelById(this.state.id).then( (res) =>{
                let dynamicsmodel = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDynamicsmodel = (e) => {
        e.preventDefault();
        let dynamicsmodel = {
                dynamicsmodelId: this.state.id,
            };
        console.log('dynamicsmodel => ' + JSON.stringify(dynamicsmodel));

        // step 5
        if(this.state.id === '_add'){
            dynamicsmodel.dynamicsmodelId=''
            DynamicsmodelService.createDynamicsmodel(dynamicsmodel).then(res =>{
                this.props.history.push('/dynamicsmodels');
            });
        }else{
            DynamicsmodelService.updateDynamicsmodel(dynamicsmodel).then( res => {
                this.props.history.push('/dynamicsmodels');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/dynamicsmodels');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Dynamicsmodel</h3>
        }else{
            return <h3 className="text-center">Update Dynamicsmodel</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDynamicsmodel}>Save</button>
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

export default CreateDynamicsmodelComponent
