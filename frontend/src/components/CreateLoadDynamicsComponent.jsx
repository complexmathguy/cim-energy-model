import React, { Component } from 'react'
import LoadDynamicsService from '../services/LoadDynamicsService';

class CreateLoadDynamicsComponent extends Component {
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
            LoadDynamicsService.getLoadDynamicsById(this.state.id).then( (res) =>{
                let loadDynamics = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadDynamics = (e) => {
        e.preventDefault();
        let loadDynamics = {
                loadDynamicsId: this.state.id,
            };
        console.log('loadDynamics => ' + JSON.stringify(loadDynamics));

        // step 5
        if(this.state.id === '_add'){
            loadDynamics.loadDynamicsId=''
            LoadDynamicsService.createLoadDynamics(loadDynamics).then(res =>{
                this.props.history.push('/loadDynamicss');
            });
        }else{
            LoadDynamicsService.updateLoadDynamics(loadDynamics).then( res => {
                this.props.history.push('/loadDynamicss');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadDynamicss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadDynamics</h3>
        }else{
            return <h3 className="text-center">Update LoadDynamics</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadDynamics}>Save</button>
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

export default CreateLoadDynamicsComponent
