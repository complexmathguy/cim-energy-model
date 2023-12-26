import React, { Component } from 'react'
import SubLoadAreaService from '../services/SubLoadAreaService';

class CreateSubLoadAreaComponent extends Component {
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
            SubLoadAreaService.getSubLoadAreaById(this.state.id).then( (res) =>{
                let subLoadArea = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateSubLoadArea = (e) => {
        e.preventDefault();
        let subLoadArea = {
                subLoadAreaId: this.state.id,
            };
        console.log('subLoadArea => ' + JSON.stringify(subLoadArea));

        // step 5
        if(this.state.id === '_add'){
            subLoadArea.subLoadAreaId=''
            SubLoadAreaService.createSubLoadArea(subLoadArea).then(res =>{
                this.props.history.push('/subLoadAreas');
            });
        }else{
            SubLoadAreaService.updateSubLoadArea(subLoadArea).then( res => {
                this.props.history.push('/subLoadAreas');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/subLoadAreas');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SubLoadArea</h3>
        }else{
            return <h3 className="text-center">Update SubLoadArea</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSubLoadArea}>Save</button>
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

export default CreateSubLoadAreaComponent
