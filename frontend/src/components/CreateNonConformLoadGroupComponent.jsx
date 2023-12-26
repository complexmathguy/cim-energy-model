import React, { Component } from 'react'
import NonConformLoadGroupService from '../services/NonConformLoadGroupService';

class CreateNonConformLoadGroupComponent extends Component {
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
            NonConformLoadGroupService.getNonConformLoadGroupById(this.state.id).then( (res) =>{
                let nonConformLoadGroup = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateNonConformLoadGroup = (e) => {
        e.preventDefault();
        let nonConformLoadGroup = {
                nonConformLoadGroupId: this.state.id,
            };
        console.log('nonConformLoadGroup => ' + JSON.stringify(nonConformLoadGroup));

        // step 5
        if(this.state.id === '_add'){
            nonConformLoadGroup.nonConformLoadGroupId=''
            NonConformLoadGroupService.createNonConformLoadGroup(nonConformLoadGroup).then(res =>{
                this.props.history.push('/nonConformLoadGroups');
            });
        }else{
            NonConformLoadGroupService.updateNonConformLoadGroup(nonConformLoadGroup).then( res => {
                this.props.history.push('/nonConformLoadGroups');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/nonConformLoadGroups');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add NonConformLoadGroup</h3>
        }else{
            return <h3 className="text-center">Update NonConformLoadGroup</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateNonConformLoadGroup}>Save</button>
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

export default CreateNonConformLoadGroupComponent
