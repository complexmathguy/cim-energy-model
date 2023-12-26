import React, { Component } from 'react'
import ConformLoadGroupService from '../services/ConformLoadGroupService';

class CreateConformLoadGroupComponent extends Component {
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
            ConformLoadGroupService.getConformLoadGroupById(this.state.id).then( (res) =>{
                let conformLoadGroup = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConformLoadGroup = (e) => {
        e.preventDefault();
        let conformLoadGroup = {
                conformLoadGroupId: this.state.id,
            };
        console.log('conformLoadGroup => ' + JSON.stringify(conformLoadGroup));

        // step 5
        if(this.state.id === '_add'){
            conformLoadGroup.conformLoadGroupId=''
            ConformLoadGroupService.createConformLoadGroup(conformLoadGroup).then(res =>{
                this.props.history.push('/conformLoadGroups');
            });
        }else{
            ConformLoadGroupService.updateConformLoadGroup(conformLoadGroup).then( res => {
                this.props.history.push('/conformLoadGroups');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/conformLoadGroups');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConformLoadGroup</h3>
        }else{
            return <h3 className="text-center">Update ConformLoadGroup</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConformLoadGroup}>Save</button>
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

export default CreateConformLoadGroupComponent
