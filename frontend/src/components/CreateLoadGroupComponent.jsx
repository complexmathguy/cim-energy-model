import React, { Component } from 'react'
import LoadGroupService from '../services/LoadGroupService';

class CreateLoadGroupComponent extends Component {
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
            LoadGroupService.getLoadGroupById(this.state.id).then( (res) =>{
                let loadGroup = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateLoadGroup = (e) => {
        e.preventDefault();
        let loadGroup = {
                loadGroupId: this.state.id,
            };
        console.log('loadGroup => ' + JSON.stringify(loadGroup));

        // step 5
        if(this.state.id === '_add'){
            loadGroup.loadGroupId=''
            LoadGroupService.createLoadGroup(loadGroup).then(res =>{
                this.props.history.push('/loadGroups');
            });
        }else{
            LoadGroupService.updateLoadGroup(loadGroup).then( res => {
                this.props.history.push('/loadGroups');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/loadGroups');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add LoadGroup</h3>
        }else{
            return <h3 className="text-center">Update LoadGroup</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateLoadGroup}>Save</button>
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

export default CreateLoadGroupComponent
