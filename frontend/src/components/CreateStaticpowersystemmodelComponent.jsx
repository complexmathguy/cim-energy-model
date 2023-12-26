import React, { Component } from 'react'
import StaticpowersystemmodelService from '../services/StaticpowersystemmodelService';

class CreateStaticpowersystemmodelComponent extends Component {
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
            StaticpowersystemmodelService.getStaticpowersystemmodelById(this.state.id).then( (res) =>{
                let staticpowersystemmodel = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateStaticpowersystemmodel = (e) => {
        e.preventDefault();
        let staticpowersystemmodel = {
                staticpowersystemmodelId: this.state.id,
            };
        console.log('staticpowersystemmodel => ' + JSON.stringify(staticpowersystemmodel));

        // step 5
        if(this.state.id === '_add'){
            staticpowersystemmodel.staticpowersystemmodelId=''
            StaticpowersystemmodelService.createStaticpowersystemmodel(staticpowersystemmodel).then(res =>{
                this.props.history.push('/staticpowersystemmodels');
            });
        }else{
            StaticpowersystemmodelService.updateStaticpowersystemmodel(staticpowersystemmodel).then( res => {
                this.props.history.push('/staticpowersystemmodels');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/staticpowersystemmodels');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Staticpowersystemmodel</h3>
        }else{
            return <h3 className="text-center">Update Staticpowersystemmodel</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateStaticpowersystemmodel}>Save</button>
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

export default CreateStaticpowersystemmodelComponent
